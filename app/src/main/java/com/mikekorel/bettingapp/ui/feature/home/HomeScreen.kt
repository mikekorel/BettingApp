package com.mikekorel.bettingapp.ui.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.mikekorel.bettingapp.ui.theme.AppTheme

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
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Home Screen",
            color = AppTheme.colors.blue,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    AppTheme {
        HomeScreenContent(currState = State(), onEvent = { })
    }
}