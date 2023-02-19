package com.adammcneilly.reader.home

import androidx.lifecycle.ViewModel
import com.adammcneilly.reader.displaymodels.HomeNavigationTabDisplayModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * A state management container for the home screen of the application.
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        setInitialTabs()
    }

    private fun setInitialTabs() {
        val tabs = HomeNavigationTab.values().map { tab ->
            HomeNavigationTabDisplayModel(
                tab = tab,
                selected = HomeNavigationTab.START_DESTINATION == tab,
                onClick = {
                    setSelectedTab(tab)
                },
            )
        }

        _state.update { currentState ->
            currentState.copy(
                navigationTabs = tabs,
            )
        }
    }

    private fun setSelectedTab(
        newTab: HomeNavigationTab,
    ) {
        _state.update { currentState ->
            val updatedTabs = currentState.navigationTabs.map { tabDisplayModel ->
                tabDisplayModel.copy(
                    selected = tabDisplayModel.tab == newTab,
                )
            }

            currentState.copy(
                navigationTabs = updatedTabs,
                selectedTab = newTab,
            )
        }
    }

    fun clearSelectedTab() {
        _state.update { currentState ->
            currentState.copy(
                selectedTab = null,
            )
        }
    }
}
