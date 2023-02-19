package com.adammcneilly.reader.booksearch

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.adammcneilly.reader.ui.theme.ReaderTheme

@Composable
fun BookSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: BookSearchViewModel = hiltViewModel(),
    onBookClicked: (String) -> Unit = {},
) {
    val viewState = viewModel.viewState.collectAsState()

    BookSearchContent(
        viewState = viewState.value,
        onSearchTextChange = viewModel::searchTextChanged,
        modifier = modifier.padding(ReaderTheme.sizing.screenPadding),
        onBookClicked = onBookClicked,
    )
}
