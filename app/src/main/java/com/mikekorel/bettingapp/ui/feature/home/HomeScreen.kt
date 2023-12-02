package com.mikekorel.bettingapp.ui.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikekorel.bettingapp.common.CollectAsEffect
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.Event
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.State
import com.mikekorel.bettingapp.ui.feature.home.components.SportSectionHeader
import com.mikekorel.bettingapp.ui.feature.home.components.SportSectionItem
import com.mikekorel.designsystem.theme.AppTheme
import com.mikekorel.designsystem.theme.AppTheme.colors
import com.mikekorel.designsystem.theme.AppTheme.sizing
import com.mikekorel.designsystem.theme.AppTheme.spacing

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
private fun HomeScreenContent(
    currState: State,
    onEvent: (Event) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.grey)
    ) {
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
                        sectionExpanded = sport.id !in currState.hiddenSectionSportIds
                    ) {
                        sport.id?.let { id ->
                            onEvent(Event.OnSectionExpandClicked(id))
                        }
                    }
                }

                sport.events?.let { events ->
                    items(events) {
                        AnimatedVisibility(
                            visible = sport.id !in currState.hiddenSectionSportIds,
                            enter = expandVertically(expandFrom = Alignment.Top),
                            exit = shrinkVertically()
                        ) {
                            SportSectionItem(sportEvent = it)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    AppTheme {
        HomeScreenContent(currState = State(), onEvent = { })
    }
}