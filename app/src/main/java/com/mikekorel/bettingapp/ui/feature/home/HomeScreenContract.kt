package com.mikekorel.bettingapp.ui.feature.home

import com.mikekorel.bettingapp.core.UiEffect
import com.mikekorel.bettingapp.core.UiEvent
import com.mikekorel.bettingapp.core.UiState

interface HomeScreenContract {

    sealed interface Event : UiEvent {

    }

    data class State(

        override var isLoading: Boolean = false,
        override var hasError: Boolean = false,
    ) : UiState {

        sealed interface Effect : UiEffect {

        }

    }

}