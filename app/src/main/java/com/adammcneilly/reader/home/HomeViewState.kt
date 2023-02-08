package com.adammcneilly.reader.home

import com.adammcneilly.reader.displaymodels.HomeNavigationTabDisplayModel
import com.adammcneilly.reader.displaymodels.TopBarActionDisplayModel

/**
 * Defines the UI configuration of the home screen at any given point in time.
 *
 * @property[topBarActions] A list of [TopBarActionDisplayModel] entities which are rendered in the top bar
 * of the home screen.
 * @property[navigationTabs] The list of [HomeNavigationTabDisplayModel] entities to show to the user.
 * @property[selectedTab] If defined, this is a tab that we need to navigate to. Otherwise, no navigation should happen.
 */
data class HomeViewState(
    val topBarActions: List<TopBarActionDisplayModel> = emptyList(),
    val navigationTabs: List<HomeNavigationTabDisplayModel> = emptyList(),
    val selectedTab: HomeNavigationTab? = null,
)
