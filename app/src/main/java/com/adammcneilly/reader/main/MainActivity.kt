package com.adammcneilly.reader.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import com.adammcneilly.reader.ui.components.CenteredReaderTopBar
import com.adammcneilly.reader.ui.components.ReaderBottomNavigation
import com.adammcneilly.reader.ui.theme.ReaderTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    private val viewModel = MainActivityViewModel()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val viewState = viewModel.state.collectAsState()

            ReaderTheme {
                SetSystemBarsTransparent()

                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        CenteredReaderTopBar(
                            actions = viewState.value.topBarActions,
                        )
                    },
                    bottomBar = {
                        ReaderBottomNavigation()
                    },
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "search",
                        modifier = Modifier
                            .padding(it),
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
