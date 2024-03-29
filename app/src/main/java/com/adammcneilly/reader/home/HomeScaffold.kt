package com.adammcneilly.reader.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.components.ReaderBottomNavigation
import com.adammcneilly.reader.ui.components.ReaderNavigationRail

@Composable
fun HomeScaffold(
    viewState: HomeViewState,
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
            PermanentNavDrawerHomeContent(viewState, navController)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PermanentNavDrawerHomeContent(
    viewState: HomeViewState,
    navController: NavHostController,
) {
    PermanentNavigationDrawer(
        drawerContent = {
            HomePermanentNavDrawerContent(viewState)
        },
    ) {
        HomeNavHost(
            navController = navController,
            modifier = Modifier
                .statusBarsPadding(),
        )
    }
}

@Composable
private fun NavigationBarHomeContent(
    viewState: HomeViewState,
    config: HomeConfig,
    navController: NavHostController,
) {
    Column {
        Row(
            modifier = Modifier
                .weight(1F),
        ) {
            if (config.navigationType == ReaderNavigationType.NAVIGATION_RAIL) {
                ReaderNavigationRail(
                    navigationItems = viewState.navigationTabs,
                )
            }

            HomeNavHost(
                navController = navController,
                modifier = Modifier
                    .weight(1F)
                    .statusBarsPadding(),
            )
        }

        if (config.navigationType == ReaderNavigationType.BOTTOM_NAVIGATION) {
            ReaderBottomNavigation(
                navigationItems = viewState.navigationTabs,
            )
        }
    }
}
