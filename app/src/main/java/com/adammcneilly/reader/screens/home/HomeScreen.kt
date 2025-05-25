package com.adammcneilly.reader.screens.home

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.reader.core.ui.scaffold.PersistentNavigationBar
import com.adammcneilly.reader.core.ui.scaffold.PersistentNavigationRail
import com.adammcneilly.reader.core.ui.scaffold.PersistentScaffold
import com.adammcneilly.reader.core.ui.scaffold.rememberScaffoldState

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun HomeScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
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
        content = { paddingValues ->
            Text(
                text = "Home Screen Stub",
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp),
            )
        },
    )
}
