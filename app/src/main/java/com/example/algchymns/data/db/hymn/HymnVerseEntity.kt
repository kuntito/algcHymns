package com.example.algchymns.data.db.hymn

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.algchymns.data.remote.response_models.VerseType

@Entity(
    tableName = "hymn_verses",
    foreignKeys = [
        ForeignKey(
            entity = HymnEntity::class,
            parentColumns = ["hymnId"],
            childColumns = ["hymnId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HymnVerseEntity(
    @PrimaryKey val verseId: Int,
    val hymnId: Int,
    val verseType: VerseType,
    val verseOrder: Int,
    val verseLines: String
)