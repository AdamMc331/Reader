package com.adammcneilly.reader.core.displaymodels

import com.adammcneilly.reader.core.models.Author

data class AuthorDisplayModel(
    val id: String,
    val name: String,
    val image: ImageDisplayModel,
) {
    constructor(
        author: Author,
    ) : this(
        id = author.id,
        name = author.name,
        image = ImageDisplayModel.Remote(author.imageUrl),
    )
}
