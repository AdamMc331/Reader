package com.adammcneilly.reader.library

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.ui.theme.ReaderTheme

private const val LIBRARY_GRID_COLUMNS = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LibraryContent(
    viewState: LibraryViewState,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(LIBRARY_GRID_COLUMNS),
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
