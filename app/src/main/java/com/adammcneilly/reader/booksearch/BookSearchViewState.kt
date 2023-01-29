package com.adammcneilly.reader.booksearch

import com.adammcneilly.reader.displaymodels.BookDisplayModel

data class BookSearchViewState(
    val searchText: String,
    val results: List<BookDisplayModel>,
)
