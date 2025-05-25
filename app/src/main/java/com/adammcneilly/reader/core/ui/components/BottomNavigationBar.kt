package com.adammcneilly.reader.core.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adammcneilly.reader.core.app.LocalAppState
import com.adammcneilly.reader.core.app.previewAppState
import com.adammcneilly.reader.core.ui.theme.ReaderTheme

@Composable
fun BottomNavigationBar(
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

@Composable
@PreviewLightDark
@PreviewDynamicColors
private fun BottomNavigationBarPreview() {
    ReaderTheme {
        CompositionLocalProvider(
            LocalAppState provides previewAppState,
        ) {
            BottomNavigationBar()
        }
    }
}
