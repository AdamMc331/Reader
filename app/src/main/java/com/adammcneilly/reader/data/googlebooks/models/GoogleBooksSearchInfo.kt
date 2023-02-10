package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksSearchInfo(
    @Json(name = "textSnippet")
    val textSnippet: String? = null,
)
