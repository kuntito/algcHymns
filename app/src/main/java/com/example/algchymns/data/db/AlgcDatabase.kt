package com.example.algchymns.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.algchymns.data.db.hymn.HymnDao
import com.example.algchymns.data.db.hymn.HymnEntity
import com.example.algchymns.data.db.hymn.HymnVerseEntity

@Database(
    entities = [
        HymnEntity::class,
        HymnVerseEntity::class,
    ],
    version = 1,
)
abstract class AlgcDb : RoomDatabase() {
    abstract fun hymnDao(): HymnDao

    companion object {
        @Volatile
        private var INSTANCE: AlgcDb? = null

        fun getDatabase(context: Context): AlgcDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AlgcDb::class.java,
                    "algc_db",
                )
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}