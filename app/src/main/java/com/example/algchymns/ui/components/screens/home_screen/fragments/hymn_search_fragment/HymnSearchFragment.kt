package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.data.remote.response_models.dummyHymnList
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components.NoSearchResultIndicator
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components.OngoingSearchIndicator
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components.RecentSearchesFrame
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components.SearchResultsFrame
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.models.HymnSearchFragmentState
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun HymnSearchFragment(
    modifier: Modifier = Modifier,
    hymnSearchFragmentState: HymnSearchFragmentState,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        when(hymnSearchFragmentState) {
            is HymnSearchFragmentState.RecentSearches -> {
                RecentSearchesFrame(
                    recentHymns = hymnSearchFragmentState.recentSearches
                )
            }
            HymnSearchFragmentState.Searching -> {
                OngoingSearchIndicator()
            }
            is HymnSearchFragmentState.HasSearchResults -> {
                SearchResultsFrame(
                    hymnSearchResults = hymnSearchFragmentState.searchResults
                )
            }
            HymnSearchFragmentState.NoSearchFragmentResults -> {
                NoSearchResultIndicator()
            }
        }
    }
}

@Preview
@Composable
private fun HymnSearchFragmentPreview() {
    val recentSearches = dummyHymnList.take(5)
    val hymnSearchResults = dummyHymnList
    var hymnSearchFragmentState: HymnSearchFragmentState by mutableStateOf(
        HymnSearchFragmentState.RecentSearches(
            recentSearches = recentSearches
        )
    )

    val toggleState: (HymnSearchFragmentState) -> Unit = { hfs ->
        when(hfs) {
            is HymnSearchFragmentState.RecentSearches -> {
                hymnSearchFragmentState = HymnSearchFragmentState.Searching
            }
            HymnSearchFragmentState.Searching -> {
                hymnSearchFragmentState = HymnSearchFragmentState.HasSearchResults(
                    searchResults = hymnSearchResults
                )
            }
            is HymnSearchFragmentState.HasSearchResults -> {
                hymnSearchFragmentState = HymnSearchFragmentState.NoSearchFragmentResults
            }
            HymnSearchFragmentState.NoSearchFragmentResults -> {
                hymnSearchFragmentState = HymnSearchFragmentState.RecentSearches(
                    recentSearches = recentSearches
                )
            }
        }

    }

    PreviewColumn {
        TextButton(
            onClick = { toggleState(hymnSearchFragmentState) }
        ) {
            Text(
                text = "toggle state",
                style = tsOrion,
            )
        }
        HymnSearchFragment(
            hymnSearchFragmentState = hymnSearchFragmentState
        )
    }
}