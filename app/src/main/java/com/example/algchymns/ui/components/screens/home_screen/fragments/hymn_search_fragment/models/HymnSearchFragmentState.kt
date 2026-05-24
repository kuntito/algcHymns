package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.models

import com.example.algchymns.data.remote.response_models.Hymn

sealed class HymnSearchFragmentState {
    data object Idle: HymnSearchFragmentState()
    data class RecentSearches(
        val recentSearches: List<Hymn>
    ): HymnSearchFragmentState()

    data object Searching: HymnSearchFragmentState()

    data class HasSearchResults(
        val searchResults: List<Hymn>
    ): HymnSearchFragmentState()

    data object NoSearchResults: HymnSearchFragmentState()
}