package com.example.algchymns.data.db.hymn

import androidx.room.Embedded
import androidx.room.Relation

/**
 * a hymn and its verses.
 *
 * two entities involved:
 * - HymnEntity — the hymn data
 * - HymnVerseEntity — individual verses belonging to the hymn
 *
 * this class returns a hymn along with all its verses:
 * HymnWithVerses(
 *     hymn = HymnEntity(hymnId=1, title="Amazing Grace"),
 *     verses = [
 *         HymnVerseEntity(verseId=1, hymnId=1, verseType=VERSE, ...),
 *         HymnVerseEntity(verseId=2, hymnId=1, verseType=CHORUS, ...),
 *     ]
 * )
 *
 * HymnEntity links to HymnVerseEntity via:
 *     @Relation(
 *         parentColumn = "hymnId",
 *         entityColumn = "hymnId"
 *     )
 *
 * SQL equivalent:
 *     SELECT * FROM hymns
 *     JOIN hymn_verses ON hymns.hymnId = hymn_verses.hymnId
 *     WHERE hymns.hymnId = :hymnId
 *
 * simple one-to-many relationship. no junction table needed.
 */
data class HymnWithVersesEntity(
    @Embedded val hymn: HymnEntity,
    @Relation(
        parentColumn = "hymnId",
        entityColumn = "hymnId"
    )
    val verses: List<HymnVerseEntity>
)