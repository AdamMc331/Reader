package com.adammcneilly.reader.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavHostController
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.components.CenteredReaderTopBar
import com.adammcneilly.reader.ui.components.ReaderBottomNavigation

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScaffold(
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
        HomeContent(paddingValues, config, viewState, navController)
    }
}
