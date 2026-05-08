package com.example.algchymns.data.remote.response_models

import com.squareup.moshi.Json

enum class VerseType {
    @Json(name = "verse") VERSE,
    @Json(name = "chorus") CHORUS
}

data class HymnVerse(
    val id: Int,
    val verseType: VerseType,
    val verseOrder: Int,
    val verseLines: List<String>
)

data class Hymn(
    val id: Int,
    val title: String,
    val updatedAt: String, // or use java.time.Instant if parsing dates
    val verses: List<HymnVerse>
)

data class GetAllHymnsResponse(
    val success: Boolean,
    val hymnCount: Int? = null,
    val allHymns: List<Hymn>? = null,
    val debug: Map<String, Any>? = null,
)