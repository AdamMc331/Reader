package com.adammcneilly.reader.data.googlebooks.models

import com.adammcneilly.reader.models.Book
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
) {
    fun toBook(): Book {
        requireNotNull(this.id)
        requireNotNull(this.volumeInfo)
        requireNotNull(this.volumeInfo.title)
        requireNotNull(this.volumeInfo.authors)

        return Book(
            id = this.id,
            title = this.volumeInfo.title,
            author = this.volumeInfo.authors.joinToString(),
            thumbnailURL = this.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"),
        )
    }
}
