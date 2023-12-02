package com.mikekorel.bettingapp.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikekorel.bettingapp.R
import com.mikekorel.core.utils.CollectAsEffect
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.Event
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.State
import com.mikekorel.bettingapp.ui.feature.home.components.SportSectionHeader
import com.mikekorel.bettingapp.ui.feature.home.components.SportSectionItem
import com.mikekorel.core.utils.TestTag
import com.mikekorel.designsystem.theme.AppTheme
import com.mikekorel.designsystem.theme.AppTheme.colors
import com.mikekorel.designsystem.theme.AppTheme.sizing
import com.mikekorel.designsystem.theme.AppTheme.spacing
import com.mikekorel.designsystem.theme.Typography

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state().collectAsState()
    viewModel.effect().CollectAsEffect {
        when (it) {

            else -> {}
        }
    }

    HomeScreenContent(
        currState = state.value,
        onEvent = viewModel::onEvent,
        modifier,
    )
}

@Composable
internal fun HomeScreenContent(
    currState: State,
    onEvent: (Event) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.grey)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.blue)
                .padding(all = spacing.spacing05),
            color = colors.white,
            style = Typography.titleLarge,
        )

        when {
            currState.hasError -> { // error state
                Box(modifier = Modifier
                    .fillMaxSize()
                    .semantics { testTag = TestTag.HOME_SCREEN_ERROR_COMPONENT }
                ) {
                    Text(
                        text = stringResource(R.string.an_error_has_occurred_check_again_later),
                        style = Typography.bodyLarge,
                        modifier = Modifier.align(Alignment.Center),
                        color = colors.lightGrey,
                    )
                }
            }

            currState.sportsList.isEmpty() -> {     // empty state
                Box(modifier = Modifier
                    .fillMaxSize()
                    .semantics { testTag = TestTag.HOME_SCREEN_EMPTY_COMPONENT }
                ) {
                    Text(
                        text = stringResource(R.string.no_events_are_currently_available),
                        style = Typography.bodyLarge,
                        modifier = Modifier.align(Alignment.Center),
                        color = colors.lightGrey,
                    )
                }
            }

            else -> {   // normal state
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = sizing.xxxLarge),
                    modifier = modifier.padding(top = spacing.spacing04)
                ) {
                    for (sport in currState.sportsList) {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            SportSectionHeader(
                                sport = sport,
                                switchChecked = sport.id in currState.switchesOnSectionSportIds,
                                sectionExpanded = sport.id !in currState.hiddenSectionSportIds,
                                onSwitchClick = {
                                    sport.id?.let { id ->
                                        onEvent(Event.OnSectionSwitchClick(id))
                                    }
                                },
                                onExpandClick = {
                                    sport.id?.let { id ->
                                        onEvent(Event.OnSectionExpandClick(id))
                                    }
                                }
                            )
                        }

                        sport.events?.let { events ->
                            val sectionIsVisible = sport.id !in currState.hiddenSectionSportIds
                            val switchOn = sport.id in currState.switchesOnSectionSportIds
                            val showEvents = if (!switchOn)
                                events
                            else {
                                events.filter { it.id in currState.favoriteEventsIds }
                            }
                            if (sectionIsVisible) {
                                items(showEvents) { event ->
                                    val itemIsFavorite = event.id in currState.favoriteEventsIds
                                    SportSectionItem(
                                        sportEvent = event,
                                        isFavorite = itemIsFavorite,
                                        currTimeMillis = currState.currTimeMillis,
                                        onFavoriteClick = {
                                            onEvent(Event.OnEventFavoriteClick(it))
                                        }
                                    )
                                }
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(spacing.spacing05))
                        }
                    }
                }
            }

        }

    }
}

@Preview
@Composable
private fun HomeScreenEmptyPrev() {
    AppTheme {
        HomeScreenContent(
            currState = State(),
            onEvent = { }
        )
    }
}
@Preview
@Composable
private fun HomeScreenErrorPrev() {
    AppTheme {
        HomeScreenContent(
            currState = State(
                hasError = true,
            ),
            onEvent = { }
        )
    }
}