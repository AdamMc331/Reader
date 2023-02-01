package com.adammcneilly.reader.displaymodels

import com.adammcneilly.reader.models.Book

data class BookDisplayModel(
    val id: String,
    val title: String,
    val author: String
)

fun Book.toDisplayModel(): BookDisplayModel {
    return BookDisplayModel(
        id = this.id,
        title = this.title,
        author = this.author
    )
}
