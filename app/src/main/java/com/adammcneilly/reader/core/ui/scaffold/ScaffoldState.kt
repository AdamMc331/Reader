package com.adammcneilly.reader.core.ui.scaffold

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.window.core.layout.WindowWidthSizeClass

@OptIn(ExperimentalSharedTransitionApi::class)
class ScaffoldState(
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    private val isMediumScreenWidthOrWider: State<Boolean>,
) : AnimatedVisibilityScope by animatedVisibilityScope,
    SharedTransitionScope by sharedTransitionScope {
    internal val canShowBottomNavigation get() = !isMediumScreenWidthOrWider.value

    internal val canShowNavRail get() = isMediumScreenWidthOrWider.value
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun rememberScaffoldState(
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
): ScaffoldState {
    val isMediumScreenWidthOrWider = isMediumScreenWidthOrWider()

    return remember {
        ScaffoldState(
            animatedVisibilityScope = animatedVisibilityScope,
            sharedTransitionScope = sharedTransitionScope,
            isMediumScreenWidthOrWider = isMediumScreenWidthOrWider,
        )
    }
}

@Composable
private fun isMediumScreenWidthOrWider(): State<Boolean> {
    val widthSizeClass = currentWindowAdaptiveInfo()
        .windowSizeClass
        .windowWidthSizeClass

    val mediumOrHigherClasses = listOf(
        WindowWidthSizeClass.MEDIUM,
        WindowWidthSizeClass.EXPANDED,
    )

    val isMediumScreenWidthOrWider: Boolean = (widthSizeClass in mediumOrHigherClasses)

    return rememberUpdatedState(isMediumScreenWidthOrWider)
}
