package com.adammcneilly.reader.core.displaymodels

import com.adammcneilly.reader.core.models.Book

data class BookDisplayModel(
    val id: String,
    val title: String,
    val coverImage: ImageDisplayModel,
    val author: AuthorDisplayModel,
) {
    constructor(
        book: Book,
    ) : this(
        id = book.id,
        title = book.title,
        coverImage = ImageDisplayModel.Remote(book.coverImageUrl),
        author = AuthorDisplayModel(book.author),
    )
}
