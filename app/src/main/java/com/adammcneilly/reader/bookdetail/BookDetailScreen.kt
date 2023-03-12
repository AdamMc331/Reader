package com.adammcneilly.reader.bookdetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.reader.displaymodels.BookDisplayModel

@Composable
fun BookDetailScreen(
    bookId: String,
    modifier: Modifier = Modifier,
) {
    val viewState = BookDetailViewState(
        book = BookDisplayModel(
            id = bookId,
            thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            title = "Leviathan Wakes",
            author = "James S.A. Corey",
            isInLibrary = true,
            isRead = true,
            numPages = 534,
        ),
    )

    BookDetailContent(
        viewState = viewState,
        modifier = modifier,
    )
}

/**
 * Helper variables that define the relevant navigation arguments
 * for rendering a [BookDetailScreen].
 */
object BookDetailScreen {
    const val ARG_BOOK_ID = "bookId"
    private const val ARG_BOOK_ID_PLACEHOLDER = "{$ARG_BOOK_ID}"
    const val ROUTE_KEY = "book_detail/$ARG_BOOK_ID_PLACEHOLDER"

    fun routeForBookId(
        bookId: String,
    ): String {
        return ROUTE_KEY.replace(
            ARG_BOOK_ID_PLACEHOLDER,
            bookId,
        )
    }
}
