package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.dummyHymnList
import com.example.algchymns.ui.components.util.PreviewColumn

@Composable
fun RecentSearchesList(
    modifier: Modifier = Modifier,
    recentHymnSearches: List<Hymn>,
    onHymnClick: (Hymn) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
        modifier = modifier
        ,
    ) {
        items(items = recentHymnSearches) { h ->
            RecentSearchLi(
                hymn = h,
                onClick = { onHymnClick(h) }
            )
        }
    }
}

@Preview
@Composable
private fun RecentSearchesListPreview() {
    val recentHymnSearches = dummyHymnList
    PreviewColumn {
        RecentSearchesList(
            recentHymnSearches = recentHymnSearches,
            onHymnClick = {},
        )
    }
}