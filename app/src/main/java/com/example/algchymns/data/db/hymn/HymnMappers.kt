package com.example.algchymns.data.db.hymn

import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.HymnVerse

// domain models to db entities
fun Hymn.toHymnEntity() = HymnEntity(
    hymnId = id,
    title = title,
    updatedAt = updatedAt
)

fun HymnVerse.toHymnVerseEntity(hymnId: Int) = HymnVerseEntity(
    verseId = id,
    hymnId = hymnId,
    verseType = verseType,
    verseOrder = verseOrder,
    verseLines = verseLines.joinToString("\n")
)

// db entities to domain model
fun HymnWithVersesEntity.toHymn() = Hymn(
    id = hymn.hymnId,
    title = hymn.title,
    updatedAt = hymn.updatedAt,
    verses = verses.map { it.toHymnVerse() }
)

fun HymnVerseEntity.toHymnVerse() = HymnVerse(
    id = verseId,
    verseType = verseType,
    verseOrder = verseOrder,
    verseLines = verseLines.split("\n")
)