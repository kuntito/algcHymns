package com.example.algchymns.data.repo

import com.example.algchymns.data.db.hymn.HymnDao
import com.example.algchymns.data.db.hymn.HymnWithVersesEntity
import com.example.algchymns.data.remote.AlgcApiDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first

import kotlinx.coroutines.flow.flow

class AlgcRepo(
    private val hymnDao: HymnDao,
    private val algcDs: AlgcApiDataSource,
) {
    suspend fun getCachedHymns(): List<HymnWithVersesEntity>  {
        val allHymns = hymnDao.getAllHymnsWithVerses().first()
        return allHymns
    }


    suspend fun downloadHymns(): List<HymnWithVersesEntity>? {
        return try {
            val response = algcDs.safeFetchAllHymns()
            val maybeFetchedHymns = response?.allHymns ?: return null

            hymnDao.insertHymnsWithVerses(maybeFetchedHymns)
            getCachedHymns()
        } catch (e: Exception) {
            null
        }
    }
}