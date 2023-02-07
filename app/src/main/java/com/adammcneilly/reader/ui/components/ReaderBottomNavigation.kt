package com.adammcneilly.reader.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.R
import com.adammcneilly.reader.ui.DayNightPreview
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun ReaderBottomNavigation(
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, stringResource(id = R.string.search)) },
            label = { Text(stringResource(R.string.search)) },
            selected = true,
            onClick = { },
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.LibraryBooks, stringResource(id = R.string.library)) },
            label = { Text(stringResource(R.string.library)) },
            selected = false,
            onClick = { },
        )
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
