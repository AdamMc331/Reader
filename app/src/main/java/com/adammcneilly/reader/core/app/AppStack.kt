package com.adammcneilly.reader.core.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.reader.R

enum class AppStack(
    val titleRes: Int,
    val icon: ImageVector,
) {
    Home(
        titleRes = R.string.home,
        icon = Icons.Default.Home,
    ),
    Search(
        titleRes = R.string.search,
        icon = Icons.Default.Search,
    ),
    Account(
        titleRes = R.string.account,
        icon = Icons.Default.AccountCircle,
    ),
    Menu(
        titleRes = R.string.menu,
        icon = Icons.Default.Menu,
    ),
}
