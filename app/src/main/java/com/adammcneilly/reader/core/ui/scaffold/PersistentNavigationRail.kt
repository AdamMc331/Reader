package com.adammcneilly.reader.core.ui.scaffold

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.core.ui.components.SideNavigationRail

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun ScaffoldState.PersistentNavigationRail(
    modifier: Modifier = Modifier,
    enterTransition: EnterTransition = slideInVertically(initialOffsetY = { it }),
    exitTransition: ExitTransition = slideOutVertically(targetOffsetY = { it }),
) {
    AnimatedVisibility(
        modifier = modifier
            .sharedElement(
                sharedContentState = rememberSharedContentState(
                    NavRailSharedElementKey,
                ),
                animatedVisibilityScope = this,
            ),
        visible = canShowNavRail,
        enter = enterTransition,
        exit = exitTransition,
        content = {
            SideNavigationRail()
        },
    )
}

private data object NavRailSharedElementKey
