package com.adammcneilly.reader.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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

class HomeActivity : ComponentActivity() {
    private val viewModel = HomeViewModel()

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

                Scaffold(
                    topBar = {
                        CenteredReaderTopBar(
                            actions = viewState.value.topBarActions,
                            actionType = config.appBarActionType,
                        )
                    },
                    bottomBar = {
                        if (config.navigationType == ReaderNavigationType.BOTTOM_NAVIGATION) {
                            ReaderBottomNavigation()
                        }
                    },
                ) {
                    Row(
                        Modifier
                            .padding(it),
                    ) {
                        if (config.navigationType == ReaderNavigationType.NAVIGATION_RAIL) {
                            ReaderNavigationRail()
                        }

                        NavHost(
                            navController = navController,
                            startDestination = "search",
                            modifier = Modifier
                                .weight(1F),
                        ) {
                            composable("search") {
                                BookSearchScreen(
                                    viewModel = BookSearchViewModel(),
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
