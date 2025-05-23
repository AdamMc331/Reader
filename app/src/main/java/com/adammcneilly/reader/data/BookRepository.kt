package com.adammcneilly.reader.data

import com.adammcneilly.reader.core.models.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun searchBooks(
        query: String,
    ): Flow<List<Book>>
}
