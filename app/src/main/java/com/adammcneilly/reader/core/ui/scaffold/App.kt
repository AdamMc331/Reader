package com.adammcneilly.reader.core.ui.scaffold

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.reader.core.app.AppState
import com.adammcneilly.reader.core.app.LocalAppState
import com.adammcneilly.reader.core.ui.theme.ReaderTheme
import com.adammcneilly.reader.screens.account.AccountScreen
import com.adammcneilly.reader.screens.home.HomeScreen
import com.adammcneilly.reader.screens.menu.MenuScreen
import com.adammcneilly.reader.screens.search.SearchScreen

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun App(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    ReaderTheme {
        Surface {
            SharedTransitionLayout(
                modifier = modifier
                    .fillMaxSize(),
            ) {
                CompositionLocalProvider(
                    LocalAppState provides appState,
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun SharedTransitionScope.AppNavHost() {
    val navController = rememberNavController()
    val appState = LocalAppState.current

    val currentTab = appState.currentSelectedTab

    LaunchedEffect(currentTab) {
        val route = currentTab?.route

        if (route != null) {
            if (navController.currentBackStackEntry?.destination?.route != route) {
                navController.navigate(route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = "search",
    ) {
        composable("home") {
            HomeScreen(
                animatedVisibilityScope = this@composable,
                sharedTransitionScope = this@AppNavHost,
            )
        }

        composable("search") {
            SearchScreen(
                animatedVisibilityScope = this@composable,
                sharedTransitionScope = this@AppNavHost,
            )
        }

        composable("account") {
            AccountScreen(
                animatedVisibilityScope = this@composable,
                sharedTransitionScope = this@AppNavHost,
            )
        }

        composable("menu") {
            MenuScreen(
                animatedVisibilityScope = this@composable,
                sharedTransitionScope = this@AppNavHost,
            )
        }
    }
}
