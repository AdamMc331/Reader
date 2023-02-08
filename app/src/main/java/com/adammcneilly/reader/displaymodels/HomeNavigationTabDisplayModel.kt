package com.adammcneilly.reader.displaymodels

import com.adammcneilly.reader.home.HomeNavigationTab

/**
 * A user friendly representation of a navigation item that appears in either
 * a bottom navigation or a navigation rail.
 *
 * @property[tab] The [HomeNavigationTab] currently being viewed by the user.
 * @property[selected] If true, this navigation item will show a selected state.
 * @property[onClick] A callback to trigger when the user taps on this navigation item.
 */
data class HomeNavigationTabDisplayModel(
    val tab: HomeNavigationTab,
    val selected: Boolean,
    val onClick: () -> Unit,
)
