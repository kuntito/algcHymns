package com.example.algchymns

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algchymns.data.db.hymn.toHymn
import com.example.algchymns.data.repo.AlgcRepo
import com.example.algchymns.ui.components.screens.home_screen.models.HymnSyncState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HymnViewModel(
    private val repo: AlgcRepo,
): ViewModel() {

    private val _hymnSyncState = MutableStateFlow<HymnSyncState>(
        HymnSyncState.Idle
    )
    val hymnSyncState: StateFlow<HymnSyncState>
        get() = _hymnSyncState


    init {
        viewModelScope.launch {
            val cachedHymns = repo.getCachedHymns()
            if (cachedHymns.isNotEmpty()) {
                _hymnSyncState.value = HymnSyncState.HymnsLoaded(
                    hymns = cachedHymns.map { it.toHymn() }
                )
            } else {
                downloadHymns()
            }
        }
    }

    private fun downloadHymns() {
        viewModelScope.launch {
            _hymnSyncState.value = HymnSyncState.DownloadingHymns
            val downloadedHymns = repo.downloadHymns()

            _hymnSyncState.value = if (downloadedHymns == null) {
                HymnSyncState.HymnDownloadError
            } else {
                HymnSyncState.HymnsLoaded(
                    hymns = downloadedHymns.map{ it.toHymn() }
                )
            }
        }
    }

    fun retryHymnsDownload() = downloadHymns()
}