package com.adammcneilly.reader.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.components.ReaderNavigationRail

@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    config: HomeConfig,
    viewState: State<HomeViewState>,
    navController: NavHostController,
) {
    Row(
        modifier = Modifier
            .padding(paddingValues),
    ) {
        if (config.navigationType == ReaderNavigationType.NAVIGATION_RAIL) {
            ReaderNavigationRail(
                navigationItems = viewState.value.navigationTabs,
            )
        }

        HomeNavHost(
            navController = navController,
            modifier = Modifier
                .weight(1F),
        )
    }
}
