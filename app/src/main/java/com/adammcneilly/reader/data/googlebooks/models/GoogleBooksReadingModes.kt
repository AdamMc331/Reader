package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksReadingModes(
    @Json(name = "image")
    val image: Boolean? = null,
    @Json(name = "text")
    val text: Boolean? = null,
)
