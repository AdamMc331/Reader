package com.adammcneilly.reader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.adammcneilly.reader.core.ui.theme.ReaderTheme
import com.adammcneilly.reader.screens.search.SearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            ReaderTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SearchScreen()
                }
            }
        }
    }
}
