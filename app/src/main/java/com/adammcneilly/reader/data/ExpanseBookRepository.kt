package com.adammcneilly.reader.data

import com.adammcneilly.reader.models.Book
import javax.inject.Inject

/**
 * A custom implementation of [BookRepository] that will be used for demo purposes.
 */
@Suppress("MaxLineLength")
class ExpanseBookRepository @Inject constructor() : BookRepository {
    private val expanseBooks = listOf(
        Book(
            id = "1",
            title = "Leviathan Wakes",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
            isRead = true,
        ),
        Book(
            id = "2",
            title = "Caliban's War",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=tXGRBgwxAHIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
            isRead = true,
        ),
        Book(
            id = "3",
            title = "Abaddon's Gate",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=rIWWl_bA0z4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
        ),
        Book(
            id = "4",
            title = "Cibola Burn",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=pGe1oQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api",
            isInLibrary = true,
        ),
        Book(
            id = "5",
            title = "Nemesis Games",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=A_-zBAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
        ),
        Book(
            id = "6",
            title = "Babylon's Ashes",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
        ),
        Book(
            id = "7",
            title = "Persepolis Rising",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
        ),
        Book(
            id = "8",
            title = "Tiamat's Wrath",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
        ),
        Book(
            id = "9",
            title = "Leviathan Falls",
            author = "James S.A. Corey",
            thumbnailURL = "https://books.google.com/books/content?id=yud-foXqGUEC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
            isInLibrary = true,
        ),
    )

    override suspend fun getAllBooksInLibrary(): List<Book> {
        val ownedIds = listOf("1", "2", "3", "4", "5")

        return expanseBooks.filter { book ->
            ownedIds.contains(book.id)
        }
    }
}
