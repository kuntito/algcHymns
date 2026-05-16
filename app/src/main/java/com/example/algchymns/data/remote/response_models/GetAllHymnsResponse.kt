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

val dummyHymnVerse = HymnVerse(
    id = 0,
    verseType = VerseType.VERSE,
    verseOrder = 0,
    verseLines = listOf(
        "Above all Powers, Above all Kings",
        "Above all nature and all created things",
        "Above all wealth and treasure of the earth",
        "You were here before the world began"
    )
)

val dummyChorus = HymnVerse(
    id = 1,
    verseType = VerseType.CHORUS,
    verseOrder = 1,
    verseLines = listOf(
        "Crucified, laid behind a stone",
        "You lived to die, rejected and alone",
        "Like a rose, trampled on the ground",
        "You took the fall, and thought of me, above all"
    )
)

val dummyHymn = Hymn(
    id = 1,
    title = "Above All Power",
    updatedAt = "2026-01-01T00:00:00Z",
    verses = listOf(dummyHymnVerse, dummyChorus)
)

val dummyHymnList = listOf(
    dummyHymn.copy(id = 1, title = "Above All Power"),
    dummyHymn.copy(id = 2, title = "Amazing Grace"),
    dummyHymn.copy(id = 3, title = "How Great Thou Art"),
    dummyHymn.copy(id = 4, title = "Holy Holy Holy"),
    dummyHymn.copy(id = 5, title = "Great Is Thy Faithfulness And The Way it is going"),
    dummyHymn.copy(id = 6, title = "It Is Well With My Soul"),
    dummyHymn.copy(id = 7, title = "To God Be The Glory"),
    dummyHymn.copy(id = 8, title = "Blessed Assurance"),
    dummyHymn.copy(id = 9, title = "Come Thou Fount"),
    dummyHymn.copy(id = 10, title = "Crown Him With Many Crowns"),
    dummyHymn.copy(id = 11, title = "Be Thou My Vision"),
    dummyHymn.copy(id = 12, title = "Immortal Invisible"),
    dummyHymn.copy(id = 13, title = "And Can It Be"),
    dummyHymn.copy(id = 14, title = "O For A Thousand Tongues"),
    dummyHymn.copy(id = 15, title = "Praise To The Lord"),
    dummyHymn.copy(id = 16, title = "Joyful Joyful We Adore Thee"),
    dummyHymn.copy(id = 17, title = "All Creatures Of Our God"),
    dummyHymn.copy(id = 18, title = "This Is My Father's World"),
    dummyHymn.copy(id = 19, title = "Fairest Lord Jesus"),
    dummyHymn.copy(id = 20, title = "All Hail The Power"),
)