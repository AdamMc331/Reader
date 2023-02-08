package com.adammcneilly.reader.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.displaymodels.HomeNavigationTabDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun ReaderNavigationRail(
    modifier: Modifier = Modifier,
    navigationItems: List<HomeNavigationTabDisplayModel> = emptyList(),
) {
    NavigationRail(
        modifier = modifier,
    ) {
        navigationItems.forEach { navigationItem ->
            NavigationRailItem(
                icon = { Icon(navigationItem.tab.icon, stringResource(navigationItem.tab.textRes)) },
                label = { Text(stringResource(navigationItem.tab.textRes)) },
                selected = navigationItem.selected,
                onClick = navigationItem.onClick,
            )
        }
    }
}

@Composable
@DayNightPreview
private fun ReaderNavigationRailPreview() {
    ReaderTheme {
        Surface {
            ReaderNavigationRail()
        }
    }
}
