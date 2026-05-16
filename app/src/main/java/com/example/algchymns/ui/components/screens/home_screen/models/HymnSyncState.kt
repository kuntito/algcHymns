package com.example.algchymns.ui.components.screens.home_screen.models

import com.example.algchymns.data.remote.response_models.Hymn

sealed class HymnSyncState {
    data object Idle: HymnSyncState()
    data object DownloadingHymns: HymnSyncState()
    data object HymnDownloadError: HymnSyncState()
    data class HymnsLoaded(
        val hymns: List<Hymn>
    ): HymnSyncState()
    data object HymnsUpdate: HymnSyncState()
}