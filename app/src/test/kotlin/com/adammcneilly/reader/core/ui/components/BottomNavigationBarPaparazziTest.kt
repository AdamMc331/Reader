package com.adammcneilly.reader.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import com.adammcneilly.reader.BasePaparazziTest
import com.adammcneilly.reader.R
import com.adammcneilly.reader.core.displaymodels.NavigationItemDisplayModel
import org.junit.Test

class BottomNavigationBarPaparazziTest : BasePaparazziTest() {
    @Test
    fun renderDefault() {
        snapshot(
            screenPaddingDp = 0,
        ) {
            BottomNavigationBar(
                items = listOf(
                    NavigationItemDisplayModel(
                        icon = Icons.Default.Home,
                        labelRes = R.string.home,
                        selected = true,
                    ),
                    NavigationItemDisplayModel(
                        icon = Icons.Default.Search,
                        labelRes = R.string.search,
                        selected = false,
                    ),
                    NavigationItemDisplayModel(
                        icon = Icons.Default.AccountCircle,
                        labelRes = R.string.account,
                        selected = false,
                    ),
                    NavigationItemDisplayModel(
                        icon = Icons.Default.Menu,
                        labelRes = R.string.menu,
                        selected = false,
                    ),
                ),
            )
        }
    }
}
