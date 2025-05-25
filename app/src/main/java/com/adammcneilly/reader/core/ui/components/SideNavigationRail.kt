package com.adammcneilly.reader.core.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adammcneilly.reader.core.app.AppState
import com.adammcneilly.reader.core.app.AppStateData
import com.adammcneilly.reader.core.app.LocalAppState
import com.adammcneilly.reader.core.ui.theme.ReaderTheme

@Composable
fun SideNavigationRail(
    modifier: Modifier = Modifier,
) {
    val appState = LocalAppState.current

    NavigationRail(
        modifier = modifier,
    ) {
        appState.navItems.forEach { item ->
            NavigationRailItem(
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

@Composable
@PreviewLightDark
@PreviewDynamicColors
private fun SideNavigationRailPreview() {
    ReaderTheme {
        CompositionLocalProvider(
            LocalAppState provides AppState(AppStateData()),
        ) {
            SideNavigationRail()
        }
    }
}
