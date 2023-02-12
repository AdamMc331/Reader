package com.adammcneilly.reader.displaymodels

import com.adammcneilly.reader.models.Book

/**
 * A user friendly representation of a [Book] domain entity.
 *
 * @see[Book] for field documentation.
 */
data class BookDisplayModel(
    val id: String = "",
    val title: String = "",
    val author: String = "",
    val thumbnailURL: String? = null,
    val isInLibrary: Boolean = false,
    val isRead: Boolean = false,
)

fun Book.toDisplayModel(): BookDisplayModel {
    return BookDisplayModel(
        id = this.id,
        title = this.title,
        author = this.author,
        thumbnailURL = this.thumbnailURL,
        isInLibrary = this.isInLibrary,
        isRead = this.isRead,
    )
}
