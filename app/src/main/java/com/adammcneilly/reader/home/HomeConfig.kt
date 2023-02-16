package com.adammcneilly.reader.home

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.adammcneilly.reader.ui.ReaderNavigationType
import com.adammcneilly.reader.ui.TopBarActionType

/**
 * Defines the configurations for the home screen that may change based on window size. This class should
 * be generated using the [fromWindowSize] method.
 *
 * @property[appBarActionType] The [TopBarActionType] to render on the home screen.
 * @property[navigationType] The [ReaderNavigationType] used to navigate within the home screen.
 */
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
                        navigationType = ReaderNavigationType.PERMANENT_NAVIGATION_DRAWER,
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
