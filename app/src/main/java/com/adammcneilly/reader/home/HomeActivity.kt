package com.adammcneilly.reader.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.reader.ui.theme.ReaderTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

/**
 * This activity is the main entry point to the reader application, displaying the home screen for the user.
 */
@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
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
                    navController.navigate(this.routeKey) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }

                    viewModel.clearSelectedTab()
                }

                HomeScaffold(
                    viewState = viewState.value,
                    config = config,
                    navController = navController,
                )
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
