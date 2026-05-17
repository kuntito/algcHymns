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
import com.example.algchymns.ui.components.screens.home_screen.components.HomeScreenTopBar
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_list_fragment.HymnListFragment
import com.example.algchymns.ui.components.screens.home_screen.fragments.HymnSearchFragment
import com.example.algchymns.ui.components.screens.home_screen.models.HymnSyncState
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.rememberCustomTextFieldState

@Composable
fun HomeScreenRoot(
    hymnViewModel: HymnViewModel,
) {
    val hymnSyncState by hymnViewModel.hymnSyncState.collectAsState()
    val retryHymnsDownload = hymnViewModel::retryHymnsDownload
    HomeScreen(
        hymnSyncState = hymnSyncState,
        onSearchQueryChange = {},
        retryHymnsDownload = retryHymnsDownload,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    hymnSyncState: HymnSyncState,
    onSearchQueryChange: (String) -> Unit,
    retryHymnsDownload: () -> Unit,
) {

    val searchFieldState = rememberCustomTextFieldState(
        onQueryChange = onSearchQueryChange,
    )

    val isSearchFocused by searchFieldState.isFocused.collectAsState()
    val navFromSearchFragment: () -> Unit = {
        searchFieldState.clearText(
            isTyping = false
        )
        searchFieldState.onFocusChange(false)
    }

    Scaffold(
        topBar = {
            HomeScreenTopBar(
                searchFieldState = searchFieldState,
                navFromSearchFragment = navFromSearchFragment,
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
            if (isSearchFocused) {
                HymnSearchFragment()
            } else {
                HymnListFragment(
                    hymnSyncState = hymnSyncState,
                    retryHymnsDownload = retryHymnsDownload,
                )
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