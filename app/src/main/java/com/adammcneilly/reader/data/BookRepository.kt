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

    /**
     * Retrieves a list of [Book] entities that are part of the user's library
     * (either read, or to be read).
     */
    suspend fun getBooksInLibrary(): List<Book>
}
