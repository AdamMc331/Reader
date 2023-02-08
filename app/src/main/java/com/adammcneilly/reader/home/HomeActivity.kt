package com.adammcneilly.reader.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.reader.booksearch.BookSearchScreen
import com.adammcneilly.reader.booksearch.BookSearchViewModel
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.components.CenteredReaderTopBar
import com.adammcneilly.reader.ui.components.ReaderBottomNavigation
import com.adammcneilly.reader.ui.components.ReaderNavigationRail
import com.adammcneilly.reader.ui.theme.ReaderTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * This activity is the main entry point to the reader application, displaying the home screen for the user.
 */
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val viewState = viewModel.state.collectAsState()

            ReaderTheme {
                SetSystemBarsTransparent()

                val windowSize = calculateWindowSizeClass(this)
                val navController = rememberNavController()
                val config = HomeConfig.fromWindowSize(windowSize)

                viewState.value.selectedTab?.run {
                    navController.navigate(this.routeKey)

                    viewModel.clearSelectedTab()
                }

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
                ) {
                    Row(
                        Modifier
                            .padding(it),
                    ) {
                        if (config.navigationType == ReaderNavigationType.NAVIGATION_RAIL) {
                            ReaderNavigationRail(
                                navigationItems = viewState.value.navigationTabs,
                            )
                        }

                        NavHost(
                            navController = navController,
                            startDestination = HomeNavigationTab.START_DESTINATION.routeKey,
                            modifier = Modifier
                                .weight(1F),
                        ) {
                            composable(HomeNavigationTab.SEARCH.routeKey) {
                                BookSearchScreen(
                                    viewModel = BookSearchViewModel(),
                                )
                            }

                            composable(HomeNavigationTab.LIBRARY.routeKey) {
                                Text(
                                    text = "Stub Library Screen",
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun SetSystemBarsTransparent() {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons,
            )
        }
    }
}
