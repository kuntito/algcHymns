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

    fun getAllHymns(): Flow<List<HymnWithVersesEntity>> = flow {
        val allHymns = hymnDao.getAllHymnsWithVerses().first()

        if (allHymns.isEmpty()) {
            val response = algcDs.safeFetchAllHymns()
            response?.allHymns?.let {
                hymnDao.insertHymnsWithVerses(it)
            }
        }

        emitAll(hymnDao.getAllHymnsWithVerses())
    }
}