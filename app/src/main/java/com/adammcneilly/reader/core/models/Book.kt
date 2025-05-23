package com.adammcneilly.reader.core.models

data class Book(
    val id: String,
    val title: String,
    val author: Author,
    val coverImageUrl: String,
)
