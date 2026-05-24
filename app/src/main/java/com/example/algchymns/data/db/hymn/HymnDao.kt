package com.example.algchymns.data.db.hymn

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.algchymns.data.remote.response_models.Hymn
import kotlinx.coroutines.flow.Flow

@Dao
interface HymnDao {
    @Transaction
    @Query("SELECT * FROM hymns")
    fun getAllHymnsWithVerses(): Flow<List<HymnWithVersesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHymns(hymns: List<HymnEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVerses(verses: List<HymnVerseEntity>)

    @Transaction
    suspend fun insertHymnsWithVerses(hymns: List<Hymn>) {
        val hymnEntities = hymns.map { it.toHymnEntity() }
        val verseEntities = hymns.flatMap { hymn ->
            hymn.verses.map { it.toHymnVerseEntity(hymn.id) }
        }

        insertHymns(hymnEntities)
        insertVerses(verseEntities)
    }

    @Transaction
    @Query("""
        SELECT * FROM hymns
        WHERE title LIKE '%' || :query || '%'
        OR hymnId IN (
            SELECT hymnId FROM hymn_verses
            WHERE verseLines LIKE '%' || :query || '%'
        )
    """)
    suspend fun searchForHymns(query: String): List<HymnWithVersesEntity>
}