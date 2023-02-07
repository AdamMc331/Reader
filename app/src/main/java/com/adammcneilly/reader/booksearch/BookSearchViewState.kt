package com.adammcneilly.reader.booksearch

import com.adammcneilly.reader.displaymodels.BookDisplayModel

/**
 * Defines how the UI should be rendered on the book search screen.
 *
 * @property[searchText] The current search query being used to populate books on the search screen.
 * @property[results] A collection of [BookDisplayModel] entities that appear when a user provides some [searchText].
 */
data class BookSearchViewState(
    val searchText: String = "",
    val results: List<BookDisplayModel> = emptyList(),
)
