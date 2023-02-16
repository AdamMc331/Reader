package com.adammcneilly.reader.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adammcneilly.reader.R
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.components.CenteredReaderTopBar
import com.adammcneilly.reader.ui.components.ReaderBottomNavigation
import com.adammcneilly.reader.ui.components.ReaderNavigationRail

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScaffold(
    viewState: State<HomeViewState>,
    config: HomeConfig,
    navController: NavHostController,
) {
    when (config.navigationType) {
        ReaderNavigationType.BOTTOM_NAVIGATION,
        ReaderNavigationType.NAVIGATION_RAIL,
        -> {
            NavigationBarHomeContent(viewState = viewState, config = config, navController = navController)
        }

        ReaderNavigationType.PERMANENT_NAVIGATION_DRAWER -> {
            PermanentNavigationDrawer(
                drawerContent = {
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

                            viewState.value.navigationTabs.forEach { tab ->
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
                },
            ) {
                HomeNavHost(navController = navController)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun NavigationBarHomeContent(
    viewState: State<HomeViewState>,
    config: HomeConfig,
    navController: NavHostController,
) {
    Scaffold(
        topBar = {
            CenteredReaderTopBar(
                actions = viewState.value.topBarActions,
                actionType = config.appBarActionType,
            )
        },
        bottomBar = {
            if (config.navigationType == ReaderNavigationType.BOTTOM_NAVIGATION) {
                ReaderBottomNavigation(
                    navigationItems = viewState.value.navigationTabs,
                )
            }
        },
    ) { paddingValues ->
        Row(
            modifier = Modifier.padding(paddingValues),
        ) {
            if (config.navigationType == ReaderNavigationType.NAVIGATION_RAIL) {
                ReaderNavigationRail(
                    navigationItems = viewState.value.navigationTabs,
                )
            }

            HomeNavHost(
                navController = navController,
                modifier = Modifier.weight(1F),
            )
        }
    }
}
