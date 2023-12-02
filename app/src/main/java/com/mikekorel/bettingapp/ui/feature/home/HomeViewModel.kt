package com.mikekorel.bettingapp.ui.feature.home

import androidx.lifecycle.viewModelScope
import com.mikekorel.bettingapp.core.CoreViewModel
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.Event
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.State
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.State.Effect
import com.mikekorel.core.utils.Resource
import com.mikekorel.domain.usecase.GetSportsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Timer
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSportsListUseCase: GetSportsListUseCase,
) : CoreViewModel<Event, State, Effect>(State()) {

    private var timer: Timer? = null

    init {
        getSportsList()
        startTimer()
    }

    private fun getSportsList() {
        getSportsListUseCase().onEach {
            when (it) {
                is Resource.Success -> {
                    it.data?.let {
                        setState { copy(sportsList = it) }
                    }
                }

                else -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    override suspend fun handleEvent(event: Event) {
        when (event) {
            is Event.OnSectionExpandClick -> sectionExpandClick(event)
            is Event.OnEventFavoriteClick -> eventFavoriteClick(event)
            is Event.OnSectionSwitchClick -> sectionSwitchClick(event)
        }
    }

    private fun startTimer() {
        timer = fixedRateTimer(
            period = 1000,
            daemon = true
        ) {
            setState { copy(currTimeMillis = System.currentTimeMillis()) }
        }
    }

    private fun sectionExpandClick(event: Event.OnSectionExpandClick) {
        val newSectionsHidden = state().value.hiddenSectionSportIds.toHashSet()
        if (event.sportId in newSectionsHidden) {
            newSectionsHidden.remove(event.sportId)
        } else {
            newSectionsHidden.add(event.sportId)
        }
        setState { copy(hiddenSectionSportIds = newSectionsHidden) }
    }

    private fun eventFavoriteClick(event: Event.OnEventFavoriteClick) {
        // call to backend would be performed here normally
        val newFavoriteEventIds = state().value.favoriteEventsIds.toHashSet()
        if (event.eventId in newFavoriteEventIds) {
            newFavoriteEventIds.remove(event.eventId)
        } else {
            newFavoriteEventIds.add(event.eventId)
        }
        setState { copy(favoriteEventsIds = newFavoriteEventIds) }
    }

    private fun sectionSwitchClick(event: Event.OnSectionSwitchClick) {
        val newSwitchesOn = state().value.switchesOnSectionSportIds.toHashSet()
        if (event.sportId in newSwitchesOn) {
            newSwitchesOn.remove(event.sportId)
        } else {
            newSwitchesOn.add(event.sportId)
        }
        setState { copy(switchesOnSectionSportIds = newSwitchesOn) }
    }
}