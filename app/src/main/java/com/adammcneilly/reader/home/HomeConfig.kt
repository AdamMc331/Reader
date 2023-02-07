package com.adammcneilly.reader.home

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.TopBarActionType

data class HomeConfig(
    val appBarActionType: TopBarActionType,
    val navigationType: ReaderNavigationType,
) {

    companion object {
        fun fromWindowSize(windowSizeClass: WindowSizeClass): HomeConfig {
            return when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.BOTTOM_NAVIGATION,
                        appBarActionType = TopBarActionType.ICON,
                    )
                }

                WindowWidthSizeClass.Medium -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.NAVIGATION_RAIL,
                        appBarActionType = TopBarActionType.TEXT,
                    )
                }

                WindowWidthSizeClass.Expanded -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.NAVIGATION_RAIL,
                        appBarActionType = TopBarActionType.TEXT,
                    )
                }

                else -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.BOTTOM_NAVIGATION,
                        appBarActionType = TopBarActionType.ICON,
                    )
                }
            }
        }
    }
}
