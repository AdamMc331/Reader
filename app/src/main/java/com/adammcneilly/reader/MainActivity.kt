package com.adammcneilly.reader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import com.adammcneilly.reader.core.app.AppState
import com.adammcneilly.reader.core.app.AppStateData
import com.adammcneilly.reader.core.ui.scaffold.App
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

            val appSaver = Saver<AppState, AppStateData>(
                save = { appState ->
                    appState.toSaveableData()
                },
                restore = { appStateData ->
                    AppState(appStateData)
                },
            )

            val appState = rememberSaveable(saver = appSaver) {
                AppState(
                    initialData = AppStateData(),
                )
            }

            App(
                appState = appState,
            )
        }
    }
}
