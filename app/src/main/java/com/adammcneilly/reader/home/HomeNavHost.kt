package com.adammcneilly.reader.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adammcneilly.reader.booksearch.BookSearchScreen

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
            Text(
                text = "Stub Library Screen",
            )
        }
    }
}
