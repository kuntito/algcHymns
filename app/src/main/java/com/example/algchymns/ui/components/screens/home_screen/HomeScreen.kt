package com.example.algchymns.ui.components.screens.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.HymnViewModel
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.ui.components.screens.home_screen.components.HomeScreenTopBar
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_list_fragment.HymnListFragment
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.HymnSearchFragment
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.HymnLyricsFragment
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.models.HymnSearchFragmentState
import com.example.algchymns.ui.components.screens.home_screen.models.HomeFragmentsState
import com.example.algchymns.ui.components.screens.home_screen.models.HymnSyncState
import com.example.algchymns.ui.components.util.PreviewColumn

@Composable
fun HomeScreenRoot(
    hymnViewModel: HymnViewModel,
) {
    val hymnSyncState by hymnViewModel.hymnSyncState.collectAsState()
    val retryHymnsDownload = hymnViewModel::retryHymnsDownload

    val homeFragmentsState by hymnViewModel.homeFragmentsState.collectAsState()
    val hymnSearchFragmentState by hymnViewModel.hymnSearchFragmentState.collectAsState()


    val handleSearchFocusChange = hymnViewModel::handleSearchFocusChange
    val onNavBack = hymnViewModel::onNavBack
    val onHymnClick = hymnViewModel::onHymnClick

    val onSearchQueryChange = hymnViewModel::onSearchQueryChange

    HomeScreen(
        hymnSyncState = hymnSyncState,
        homeFragmentsState = homeFragmentsState,
        onSearchQueryChange = onSearchQueryChange,
        retryHymnsDownload = retryHymnsDownload,
        navBack = onNavBack,
        handleSearchFocusChange = handleSearchFocusChange,
        onHymnClick = onHymnClick,
        hymnSearchFragmentState = hymnSearchFragmentState,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    hymnSyncState: HymnSyncState,
    homeFragmentsState: HomeFragmentsState,
    onSearchQueryChange: (String) -> Unit,
    navBack: () -> Unit,
    handleSearchFocusChange: (Boolean) -> Unit,
    onHymnClick: (Hymn) -> Unit,
    retryHymnsDownload: () -> Unit,
    hymnSearchFragmentState: HymnSearchFragmentState,
) {

    Scaffold(
        topBar = {
            HomeScreenTopBar(
                homeFragmentsState = homeFragmentsState,
                onSearchQueryChange = onSearchQueryChange,
                navBack = navBack,
                handleSearchFocusChange = handleSearchFocusChange,
            )
        },
        containerColor = Color.Unspecified,
        modifier = modifier
            .fillMaxSize()
        ,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            when(homeFragmentsState) {
                HomeFragmentsState.HymnList -> {
                    HymnListFragment(
                        hymnSyncState = hymnSyncState,
                        retryHymnsDownload = retryHymnsDownload,
                        onHymnClick = onHymnClick,
                    )
                }

                HomeFragmentsState.HymnSearch -> {
                    HymnSearchFragment(
                        hymnSearchFragmentState = hymnSearchFragmentState,
                        onHymnClick = onHymnClick,
                    )
                }

                is HomeFragmentsState.HymnLyrics -> {
                    HymnLyricsFragment(
                        hymn = homeFragmentsState.hymn
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    PreviewColumn {
        val onSearchQueryChange: (String) -> Unit = {}
//        HomeScreen(
//            onSearchQueryChange = onSearchQueryChange,
//        )
    }
}