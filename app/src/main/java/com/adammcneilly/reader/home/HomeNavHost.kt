package com.adammcneilly.reader.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adammcneilly.reader.booksearch.BookSearchScreen
import com.adammcneilly.reader.library.LibraryScreen

@Composable
fun HomeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigationTab.START_DESTINATION.routeKey,
        modifier = modifier,
    ) {
        composable(HomeNavigationTab.SEARCH.routeKey) {
            BookSearchScreen()
        }

        composable(HomeNavigationTab.LIBRARY.routeKey) {
            LibraryScreen()
        }
    }
}
