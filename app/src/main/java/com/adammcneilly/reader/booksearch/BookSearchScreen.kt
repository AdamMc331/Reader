package com.adammcneilly.reader.booksearch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun BookSearchScreen(
    viewModel: BookSearchViewModel,
    modifier: Modifier = Modifier,
) {
    val viewState = viewModel.viewState.collectAsState()

    BookSearchContent(
        viewState = viewState.value,
        onSearchTextChange = viewModel::searchTextChanged,
        modifier = modifier,
    )
}
