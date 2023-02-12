package com.adammcneilly.reader.data.googlebooks

import com.adammcneilly.reader.data.BookSearchService
import com.adammcneilly.reader.data.googlebooks.models.GoogleBooksItem
import com.adammcneilly.reader.models.Book
import javax.inject.Inject

/**
 * A concrete implementation of a [BookSearchService] that requests information
 * from the supplies [api].
 */
class GoogleBooksBookSearchService @Inject constructor(
    private val api: GoogleBooksAPI,
) : BookSearchService {

    @Suppress("TooGenericExceptionCaught", "SwallowedException")
    override suspend fun searchBooks(searchText: String): List<Book> {
        return try {
            val apiResult = api.search(searchText)

            apiResult.items?.map(GoogleBooksItem::toBook).orEmpty()
        } catch (e: Exception) {
            // Report this error
            emptyList()
        }
    }
}
