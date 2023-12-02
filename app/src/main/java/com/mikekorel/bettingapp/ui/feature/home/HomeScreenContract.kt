package com.mikekorel.bettingapp.ui.feature.home

import com.mikekorel.core.base.UiEffect
import com.mikekorel.core.base.UiEvent
import com.mikekorel.core.base.UiState
import com.mikekorel.domain.model.Sport

interface HomeScreenContract {

    sealed interface Event : UiEvent {
        data class OnSectionExpandClick(val sportId: String) : Event
        data class OnEventFavoriteClick(val eventId: String) : Event
        data class OnSectionSwitchClick(val sportId: String) : Event
    }

    data class State(
        val sportsList: List<Sport> = emptyList(),
        val hiddenSectionSportIds: HashSet<String> = hashSetOf(),
        val switchesOnSectionSportIds: HashSet<String> = hashSetOf(),
        val favoriteEventsIds: HashSet<String> = hashSetOf(),   // workaround for not having an api call to add to favorites
        val currTimeMillis: Long = System.currentTimeMillis(),

        override var isLoading: Boolean = false,
        override var hasError: Boolean = false,
    ) : UiState {

        sealed interface Effect : UiEffect {

        }

    }

}