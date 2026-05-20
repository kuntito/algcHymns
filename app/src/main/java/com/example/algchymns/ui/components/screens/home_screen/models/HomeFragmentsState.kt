package com.example.algchymns.ui.components.screens.home_screen.models

import com.example.algchymns.data.remote.response_models.Hymn

sealed class HomeFragmentsState {
    data object HymnList : HomeFragmentsState()
    data object HymnSearch: HomeFragmentsState()
    data class HymnLyrics(
        val hymn: Hymn
    ): HomeFragmentsState()
}