package com.example.algchymns.data.db.hymn

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hymns")
data class HymnEntity(
    @PrimaryKey val hymnId: Int,
    val title: String,
    val updatedAt: String
)