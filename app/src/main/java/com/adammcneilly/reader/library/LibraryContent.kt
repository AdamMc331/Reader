package com.adammcneilly.reader.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adammcneilly.reader.R
import com.adammcneilly.reader.displaymodels.BookDisplayModel
import com.adammcneilly.reader.ui.theme.ReaderTheme

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
        librarySection(
            headingTextRes = R.string.unread,
            books = viewState.unreadBooks,
        )

        librarySection(
            headingTextRes = R.string.read,
            books = viewState.readBooks,
        )
    }
}

private fun LazyGridScope.librarySection(
    headingTextRes: Int,
    books: List<BookDisplayModel>,
) {
    // In the future, maybe we want this to render a possible empty state?
    if (books.isNotEmpty()) {
        libraryHeading(headingTextRes)
        bookList(books)
    }
}

private fun LazyGridScope.bookList(
    books: List<BookDisplayModel>,
) {
    items(books) { book ->
        LibraryBookListItem(
            displayModel = book,
        )
    }
}

private fun LazyGridScope.libraryHeading(
    textRes: Int,
    modifier: Modifier = Modifier,
) {
    item(
        span = {
            GridItemSpan(maxLineSpan)
        },
    ) {
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.headlineLarge,
            modifier = modifier,
        )
    }
}
