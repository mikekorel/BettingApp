package com.mikekorel.bettingapp.ui.feature.home

import com.mikekorel.bettingapp.core.UiEffect
import com.mikekorel.bettingapp.core.UiEvent
import com.mikekorel.bettingapp.core.UiState
import com.mikekorel.domain.model.Sport

interface HomeScreenContract {

    sealed interface Event : UiEvent {
        data class OnSectionExpandClicked(val sportId: String) : Event
    }

    data class State(
        val sportsList: List<Sport> = emptyList(),
        val hiddenSectionSportIds: HashSet<String> = hashSetOf(),

        override var isLoading: Boolean = false,
        override var hasError: Boolean = false,
    ) : UiState {

        sealed interface Effect : UiEffect {

        }

    }

}