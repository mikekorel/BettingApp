package com.mikekorel.bettingapp.ui.feature.home

import com.mikekorel.bettingapp.core.CoreViewModel
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.Event
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.State
import com.mikekorel.bettingapp.ui.feature.home.HomeScreenContract.State.Effect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : CoreViewModel<Event, State, Effect>(State()) {
    override suspend fun handleEvent(event: Event) {
        when(event) {

            else -> { }
        }
    }
}