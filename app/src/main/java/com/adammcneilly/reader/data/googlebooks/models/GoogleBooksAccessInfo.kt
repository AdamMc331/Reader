package com.adammcneilly.reader.data.googlebooks.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleBooksAccessInfo(
    @Json(name = "accessViewStatus")
    val accessViewStatus: String? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "embeddable")
    val embeddable: Boolean? = null,
    @Json(name = "epub")
    val epub: GoogleBooksEpub? = null,
    @Json(name = "pdf")
    val pdf: GoogleBooksPdf? = null,
    @Json(name = "publicDomain")
    val publicDomain: Boolean? = null,
    @Json(name = "quoteSharingAllowed")
    val quoteSharingAllowed: Boolean? = null,
    @Json(name = "textToSpeechPermission")
    val textToSpeechPermission: String? = null,
    @Json(name = "viewability")
    val viewability: String? = null,
    @Json(name = "webReaderLink")
    val webReaderLink: String? = null,
)
