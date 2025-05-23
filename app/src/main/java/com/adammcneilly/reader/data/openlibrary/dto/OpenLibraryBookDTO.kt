package com.adammcneilly.reader.data.openlibrary.dto

import com.adammcneilly.reader.core.models.Author
import com.adammcneilly.reader.core.models.Book
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OpenLibraryBookDTO(
    @Json(name = "author_key")
    val authorKey: List<String?>? = null,
    @Json(name = "author_name")
    val authorName: List<String?>? = null,
    @Json(name = "cover_edition_key")
    val coverEditionKey: String? = null,
    @Json(name = "cover_i")
    val coverI: Int? = null,
    @Json(name = "ebook_access")
    val ebookAccess: String? = null,
    @Json(name = "edition_count")
    val editionCount: Int? = null,
    @Json(name = "first_publish_year")
    val firstPublishYear: Int? = null,
    @Json(name = "has_fulltext")
    val hasFulltext: Boolean? = null,
    @Json(name = "ia")
    val ia: List<String?>? = null,
    @Json(name = "ia_collection_s")
    val iaCollectionS: String? = null,
    @Json(name = "key")
    val key: String? = null,
    @Json(name = "language")
    val language: List<String?>? = null,
    @Json(name = "lending_edition_s")
    val lendingEditionS: String? = null,
    @Json(name = "lending_identifier_s")
    val lendingIdentifierS: String? = null,
    @Json(name = "public_scan_b")
    val publicScanB: Boolean? = null,
    @Json(name = "subtitle")
    val subtitle: String? = null,
    @Json(name = "title")
    val title: String? = null,
) {
    fun toBook(): Book =
        Book(
            id = key.orEmpty(),
            title = title.orEmpty(),
            author = Author(
                id = authorKey?.firstOrNull().orEmpty(),
                name = authorName?.firstOrNull().orEmpty(),
                imageUrl = "TODO:",
            ),
            coverImageUrl = "TODO:",
        )
}
