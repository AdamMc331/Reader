package com.adammcneilly.reader.data

import com.adammcneilly.reader.models.Book

interface BookRepository {
    /**
     * Retrieves a collection of [Book] entities where the title or author
     * contains the supplied [searchText].
     */
    suspend fun getBooks(
        searchText: String
    ): List<Book>
}
