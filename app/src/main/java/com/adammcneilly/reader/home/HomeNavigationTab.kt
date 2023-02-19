package com.adammcneilly.reader.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.reader.R

/**
 * Defines an enumeration of all the different tabs that represent
 * screens the user can navigate to within the home screen.
 */
enum class HomeNavigationTab(
    val icon: ImageVector,
    val textRes: Int,
    val routeKey: String,
) {
    LIBRARY(
        icon = Icons.Default.LibraryBooks,
        textRes = R.string.library,
        routeKey = "library",
    ),
    SEARCH(
        icon = Icons.Default.Search,
        textRes = R.string.search,
        routeKey = "search",
    ),
    SETTINGS(
        icon = Icons.Default.Settings,
        textRes = R.string.settings,
        routeKey = "settings",
    ),
    ;

    companion object {
        val START_DESTINATION = LIBRARY
    }
}
