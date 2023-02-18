package com.adammcneilly.reader.home

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.adammcneilly.reader.ui.ReaderNavigationType

/**
 * Defines the configurations for the home screen that may change based on window size. This class should
 * be generated using the [fromWindowSize] method.
 *
 * @property[navigationType] The [ReaderNavigationType] used to navigate within the home screen.
 */
data class HomeConfig(
    val navigationType: ReaderNavigationType,
) {

    companion object {
        fun fromWindowSize(windowSizeClass: WindowSizeClass): HomeConfig {
            return when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.BOTTOM_NAVIGATION,
                    )
                }

                WindowWidthSizeClass.Medium -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.NAVIGATION_RAIL,
                    )
                }

                WindowWidthSizeClass.Expanded -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.PERMANENT_NAVIGATION_DRAWER,
                    )
                }

                else -> {
                    HomeConfig(
                        navigationType = ReaderNavigationType.BOTTOM_NAVIGATION,
                    )
                }
            }
        }
    }
}
