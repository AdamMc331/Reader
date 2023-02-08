package com.adammcneilly.reader.library

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.ui.theme.ReaderTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LibraryContent(
    viewState: LibraryViewState,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(
            minSize = ReaderTheme.sizing.listItemMinWidth,
        ),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(ReaderTheme.sizing.verticalListSpacing),
        horizontalArrangement = Arrangement.spacedBy(ReaderTheme.sizing.verticalListSpacing),
    ) {
        items(viewState.books) { book ->
            LibraryBookListItem(
                displayModel = book,
            )
        }
    }
}
