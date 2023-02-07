package com.adammcneilly.reader.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.displaymodels.NavigationItemDisplayModel
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun ReaderBottomNavigation(
    modifier: Modifier = Modifier,
    navigationItems: List<NavigationItemDisplayModel> = emptyList(),
) {
    NavigationBar(
        modifier = modifier,
    ) {
        navigationItems.forEach { navigationItem ->
            NavigationBarItem(
                icon = { Icon(navigationItem.icon, stringResource(navigationItem.labelTextRes)) },
                label = { Text(stringResource(navigationItem.labelTextRes)) },
                selected = navigationItem.selected,
                onClick = navigationItem.onClick,
            )
        }
    }
}

@Composable
@DayNightPreview
private fun ReaderBottomNavigationPreview() {
    ReaderTheme {
        Surface {
            ReaderBottomNavigation()
        }
    }
}
