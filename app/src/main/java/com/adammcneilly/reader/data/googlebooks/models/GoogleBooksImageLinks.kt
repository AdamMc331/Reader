package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksImageLinks(
    @Json(name = "smallThumbnail")
    val smallThumbnail: String? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
)
