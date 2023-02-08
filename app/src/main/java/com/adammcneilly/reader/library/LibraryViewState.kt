package com.adammcneilly.reader.library

import com.adammcneilly.reader.displaymodels.BookDisplayModel

/**
 * Defines the UI state for the library screen.
 *
 * @property[books] All of the [BookDisplayModel] entities that are
 * part of the user's library.
 */
data class LibraryViewState(
    val books: List<BookDisplayModel> = emptyList(),
)
