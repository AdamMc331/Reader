package com.adammcneilly.reader.data

import com.adammcneilly.reader.models.Book

/**
 * Defines a data layer for searching for books that a user
 * can ultimately add to their collection.
 */
interface BookSearchService {

    /**
     * Retrieves a collection of [Book] entities where the title or author
     * contains the supplied [searchText].
     */
    suspend fun searchBooks(
        searchText: String,
    ): List<Book>
}
