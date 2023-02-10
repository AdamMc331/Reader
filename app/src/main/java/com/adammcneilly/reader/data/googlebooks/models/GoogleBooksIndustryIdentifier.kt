package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksIndustryIdentifier(
    @Json(name = "identifier")
    val identifier: String? = null,
    @Json(name = "type")
    val type: String? = null,
)
