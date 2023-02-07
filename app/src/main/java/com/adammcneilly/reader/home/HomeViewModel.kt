package com.adammcneilly.reader.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.adammcneilly.reader.R
import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        setTopBarActions()
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
}
