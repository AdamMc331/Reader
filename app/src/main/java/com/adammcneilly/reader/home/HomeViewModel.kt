package com.adammcneilly.reader.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.adammcneilly.reader.R
import com.adammcneilly.reader.displaymodels.HomeNavigationTabDisplayModel
import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * A state management container for the home screen of the application.
 */
class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        setTopBarActions()
        setInitialTabs()
    }

    private fun setTopBarActions() {
        val settingsAction = TopBarActionDisplayModel(
            icon = Icons.Default.Settings,
            textResource = R.string.settings,
            onClick = {},
        )

        _state.update { currentState ->
            currentState.copy(
                topBarActions = listOf(settingsAction),
            )
        }
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
