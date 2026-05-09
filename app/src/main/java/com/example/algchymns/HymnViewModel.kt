package com.example.algchymns

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algchymns.data.db.hymn.toHymn
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.repo.AlgcRepo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HymnViewModel(
    repo: AlgcRepo,
): ViewModel() {

    val allHymns: StateFlow<List<Hymn>> = repo.getAllHymns()
        .map { hymnWithVersesList ->
            hymnWithVersesList.map { it.toHymn() }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList(),
        )
}