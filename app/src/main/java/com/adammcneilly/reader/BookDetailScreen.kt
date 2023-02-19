package com.adammcneilly.reader

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookDetailScreen(
    bookId: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Book: $bookId",
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
