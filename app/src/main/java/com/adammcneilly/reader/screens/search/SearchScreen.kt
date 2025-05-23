package com.adammcneilly.reader.screens.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    SearchContent(
        state = state.value,
        onQueryChange = viewModel::onQueryChange,
        modifier = modifier,
    )
}
