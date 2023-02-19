package com.adammcneilly.reader.library

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.reader.ui.theme.ReaderTheme

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
        modifier = modifier
            .padding(ReaderTheme.sizing.screenPadding),
    )
}
