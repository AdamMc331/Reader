package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksListResponse(
    @Json(name = "items")
    val items: List<GoogleBooksItem>? = listOf(),
    @Json(name = "kind")
    val kind: String? = "",
    @Json(name = "totalItems")
    val totalItems: Int? = 0,
)
