package com.adammcneilly.reader.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adammcneilly.reader.R
import com.adammcneilly.reader.core.displaymodels.NavigationItemDisplayModel
import com.adammcneilly.reader.core.ui.theme.ReaderTheme

@Composable
fun SideNavigationRail(
    items: List<NavigationItemDisplayModel>,
    modifier: Modifier = Modifier,
) {
    NavigationRail(
        modifier = modifier,
    ) {
        items.forEach { item ->
            NavigationRailItem(
                selected = item.selected,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.labelRes),
                    )
                },
            )
        }
    }
}

@Composable
@PreviewLightDark
@PreviewDynamicColors
private fun SideNavigationRailPreview() {
    ReaderTheme {
        SideNavigationRail(
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
