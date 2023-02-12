package com.adammcneilly.reader.data

import com.adammcneilly.reader.models.Book

/**
 * Defines a data source for retrieving books.
 */
interface BookRepository {

    /**
     * Retrieves a list of [Book] entities that are part of the user's library
     * (either read, or to be read).
     */
    suspend fun getAllBooksInLibrary(): List<Book>
}
