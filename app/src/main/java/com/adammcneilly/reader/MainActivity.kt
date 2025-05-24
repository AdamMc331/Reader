package com.adammcneilly.reader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.reader.core.ui.theme.ReaderTheme
import com.adammcneilly.reader.screens.search.SearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            val navController = rememberNavController()

            ReaderTheme {
                SharedTransitionLayout {
                    NavHost(
                        navController = navController,
                        startDestination = "search",
                    ) {
                        composable("search") {
                            SearchScreen(
                                animatedVisibilityScope = this@composable,
                                sharedTransitionScope = this@SharedTransitionLayout,
                            )
                        }
                    }
                }
            }
        }
    }
}
