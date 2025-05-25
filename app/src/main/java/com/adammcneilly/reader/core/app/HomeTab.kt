package com.adammcneilly.reader.core.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.reader.R

/**
 * This is an enumeration of all tabs that can appear
 * on a navigation menu.
 */
enum class HomeTab(
    val route: String,
    val titleRes: Int,
    val icon: ImageVector,
) {
    Home(
        route = "home",
        titleRes = R.string.home,
        icon = Icons.Default.Home,
    ),
    Search(
        route = "search",
        titleRes = R.string.search,
        icon = Icons.Default.Search,
    ),
    Account(
        route = "account",
        titleRes = R.string.account,
        icon = Icons.Default.AccountCircle,
    ),
    Menu(
        route = "menu",
        titleRes = R.string.menu,
        icon = Icons.Default.Menu,
    ),
}
