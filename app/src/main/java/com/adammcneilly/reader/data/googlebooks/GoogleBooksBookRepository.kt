package com.adammcneilly.reader.data.googlebooks

import com.adammcneilly.reader.data.BookRepository
import com.adammcneilly.reader.models.Book
import javax.inject.Inject

/**
 * A concrete implementation of a [BookRepository] that requests information
 * from the supplies [api].
 */
class GoogleBooksBookRepository @Inject constructor(
    private val api: GoogleBooksAPI,
) : BookRepository {

    @Suppress("TooGenericExceptionCaught, SwallowedException")
    override suspend fun searchBooks(searchText: String): List<Book> {
        return try {
            val apiResult = api.search(searchText)

            apiResult.items?.map { booksItem ->
                Book(
                    id = booksItem.id.orEmpty(),
                    title = booksItem.volumeInfo?.title.orEmpty(),
                    author = booksItem.volumeInfo?.authors?.joinToString().orEmpty(),
                    thumbnailURL = booksItem.volumeInfo?.imageLinks?.thumbnail,
                )
            }
                .orEmpty()
        } catch (e: Exception) {
            // Report this error
            emptyList()
        }
    }

    override suspend fun getBooksInLibrary(): List<Book> {
        return emptyList()
    }
}
