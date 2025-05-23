package com.adammcneilly.reader.data.openlibrary

import com.adammcneilly.reader.core.models.Book
import com.adammcneilly.reader.data.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OpenLibraryBookRepository @Inject constructor(
    private val api: OpenLibraryRetrofitAPI,
) : BookRepository {
    override fun searchBooks(
        query: String,
    ): Flow<List<Book>> {
        return flow {
            val response = api.searchBooks(query)
            val books = response.docs
                ?.mapNotNull { openLibraryBookDTO ->
                    openLibraryBookDTO?.toBook()
                }.orEmpty()

            emit(books)
        }
    }
}
