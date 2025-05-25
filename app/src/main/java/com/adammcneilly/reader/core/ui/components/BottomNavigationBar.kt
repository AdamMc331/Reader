package com.adammcneilly.reader.core.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.core.app.LocalAppState
import com.adammcneilly.reader.core.displaymodels.NavigationItemDisplayModel

@Composable
fun BottomNavigationBar(
    items: List<NavigationItemDisplayModel>,
    modifier: Modifier = Modifier,
) {
    val appState = LocalAppState.current

    NavigationBar(
        modifier = modifier,
    ) {
        appState.navItems.forEach { item ->
            NavigationBarItem(
                selected = item.selected,
                onClick = {
                    appState.onNavItemSelected(item.tab)
                },
                icon = {
                    Icon(
                        imageVector = item.tab.icon,
                        contentDescription = stringResource(item.tab.titleRes),
                    )
                },
            )
        }
    }
}

// @Composable
// @PreviewLightDark
// @PreviewDynamicColors
// private fun BottomNavigationBarPreview() {
//    ReaderTheme {
//        BottomNavigationBar(
//            items = listOf(
//                NavigationItemDisplayModel(
//                    icon = Icons.Default.Home,
//                    labelRes = R.string.home,
//                    selected = true,
//                ),
//                NavigationItemDisplayModel(
//                    icon = Icons.Default.Search,
//                    labelRes = R.string.search,
//                    selected = false,
//                ),
//                NavigationItemDisplayModel(
//                    icon = Icons.Default.AccountCircle,
//                    labelRes = R.string.account,
//                    selected = false,
//                ),
//                NavigationItemDisplayModel(
//                    icon = Icons.Default.Menu,
//                    labelRes = R.string.menu,
//                    selected = false,
//                ),
//            ),
//        )
//    }
// }
