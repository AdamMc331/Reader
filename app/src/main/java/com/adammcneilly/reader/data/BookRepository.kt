package com.adammcneilly.reader.data

import com.adammcneilly.reader.models.Book

/**
 * Defines a data source for retrieving books.
 */
interface BookRepository {
    /**
     * Retrieves a collection of [Book] entities where the title or author
     * contains the supplied [searchText].
     */
    suspend fun searchBooks(
        searchText: String,
    ): List<Book>
}
