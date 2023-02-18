package com.adammcneilly.reader.home

import com.adammcneilly.reader.displaymodels.HomeNavigationTabDisplayModel

/**
 * Defines the UI configuration of the home screen at any given point in time.
 *
 * @property[navigationTabs] The list of [HomeNavigationTabDisplayModel] entities to show to the user.
 * @property[selectedTab] If defined, this is a tab that we need to navigate to. Otherwise, no navigation should happen.
 */
data class HomeViewState(
    val navigationTabs: List<HomeNavigationTabDisplayModel> = emptyList(),
    val selectedTab: HomeNavigationTab? = null,
)
