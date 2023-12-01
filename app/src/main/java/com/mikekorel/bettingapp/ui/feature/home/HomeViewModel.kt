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
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSportsListUseCase: GetSportsListUseCase,
) : CoreViewModel<Event, State, Effect>(State()) {

    init {
        getSportsList()
    }

    private fun getSportsList() {
        getSportsListUseCase().onEach {
            when(it) {
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
        when(event) {

            else -> { }
        }
    }
}