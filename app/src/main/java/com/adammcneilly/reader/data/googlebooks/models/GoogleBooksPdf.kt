package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksPdf(
    @Json(name = "acsTokenLink")
    val acsTokenLink: String? = null,
    @Json(name = "isAvailable")
    val isAvailable: Boolean? = null,
)
