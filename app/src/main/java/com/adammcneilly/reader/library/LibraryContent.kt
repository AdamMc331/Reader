package com.adammcneilly.reader.library

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LibraryContent(
    viewState: LibraryViewState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(viewState.books) { book ->
            Text(text = book.title)

            Divider()
        }
    }
}
