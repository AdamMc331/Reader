package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksItem(
    @Json(name = "accessInfo")
    val accessInfo: GoogleBooksAccessInfo? = GoogleBooksAccessInfo(),
    @Json(name = "etag")
    val etag: String? = "",
    @Json(name = "id")
    val id: String? = "",
    @Json(name = "kind")
    val kind: String? = "",
    @Json(name = "saleInfo")
    val saleInfo: GoogleBooksSaleInfo? = GoogleBooksSaleInfo(),
    @Json(name = "searchInfo")
    val searchInfo: GoogleBooksSearchInfo? = GoogleBooksSearchInfo(),
    @Json(name = "selfLink")
    val selfLink: String? = "",
    @Json(name = "volumeInfo")
    val volumeInfo: GoogleBooksVolumeInfo? = GoogleBooksVolumeInfo(),
)
