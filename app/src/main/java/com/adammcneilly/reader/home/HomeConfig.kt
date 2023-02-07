package com.adammcneilly.reader.home

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.components.CenteredReaderTopBar

data class HomeConfig(
    val appBarActionType: CenteredReaderTopBar.ActionType,
    val navigationType: ReaderNavigationType,
) {

    companion object {
        fun fromWindowSize(windowSizeClass: WindowSizeClass): HomeConfig {
            return when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.BOTTOM_NAVIGATION,
                        appBarActionType = CenteredReaderTopBar.ActionType.Icon,
                    )
                }

                WindowWidthSizeClass.Medium -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.NAVIGATION_RAIL,
                        appBarActionType = CenteredReaderTopBar.ActionType.Text,
                    )
                }

                WindowWidthSizeClass.Expanded -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.NAVIGATION_RAIL,
                        appBarActionType = CenteredReaderTopBar.ActionType.Text,
                    )
                }

                else -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.BOTTOM_NAVIGATION,
                        appBarActionType = CenteredReaderTopBar.ActionType.Icon,
                    )
                }
            }
        }
    }
}
