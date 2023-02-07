package com.adammcneilly.reader.bookdetail

import com.adammcneilly.reader.displaymodels.BookDisplayModel

/**
 * Defines how the UI should be displayed on the book detail screen.
 *
 * @property[book] The specific [BookDisplayModel] that we want to display in this detail screen.
 */
data class BookDetailViewState(
    val book: BookDisplayModel,
)
