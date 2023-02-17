package com.adammcneilly.reader.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adammcneilly.reader.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomePermanentNavDrawerContent(
    viewState: HomeViewState,
) {
    PermanentDrawerSheet(
        modifier = Modifier.sizeIn(
            minWidth = 200.dp,
            maxWidth = 200.dp,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = stringResource(id = R.string.app_name).uppercase(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )

            viewState.navigationTabs.forEach { tab ->
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = stringResource(id = tab.tab.textRes),
                        )
                    },
                    selected = tab.selected,
                    onClick = tab.onClick,
                    icon = {
                        Icon(
                            imageVector = tab.tab.icon,
                            contentDescription = null,
                        )
                    },
                )
            }
        }
    }
}
