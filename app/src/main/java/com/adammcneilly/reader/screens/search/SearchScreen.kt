package com.adammcneilly.reader.screens.search

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.reader.core.ui.scaffold.PersistentNavigationBar
import com.adammcneilly.reader.core.ui.scaffold.PersistentNavigationRail
import com.adammcneilly.reader.core.ui.scaffold.PersistentScaffold
import com.adammcneilly.reader.core.ui.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun SearchScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    rememberScaffoldState(
        animatedVisibilityScope,
        sharedTransitionScope,
    ).PersistentScaffold(
        navigationBar = {
            PersistentNavigationBar()
        },
        navigationRail = {
            PersistentNavigationRail()
        },
        content = {
            val state = viewModel.state.collectAsState()

            SearchContent(
                state = state.value,
                onEvent = viewModel::onEvent,
            )
        },
    )
}
