package com.adammcneilly.reader.library

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LibraryScreen(
    onBookClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LibraryViewModel = hiltViewModel(),
) {
    val viewState = viewModel.state.collectAsState()

    LibraryContent(
        onBookClicked = onBookClicked,
        viewState = viewState.value,
        modifier = modifier,
    )
}
