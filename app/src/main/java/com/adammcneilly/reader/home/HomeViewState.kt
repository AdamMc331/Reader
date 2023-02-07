package com.adammcneilly.reader.home

import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel

/**
 * Defines the UI configuration of the home screen at any given point in time.
 *
 * @property[topBarActions] A list of [TopBarActionDisplayModel] entities which are rendered in the top bar
 * of the home screen.
 */
data class HomeViewState(
    val topBarActions: List<TopBarActionDisplayModel> = emptyList(),
)