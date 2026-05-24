package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.dummyHymnList
import com.example.algchymns.ui.components.util.PreviewColumn

@Composable
fun SearchResultsFrame(
    modifier: Modifier = Modifier,
    hymnSearchResults: List<Hymn>,
    onHymnClick: (Hymn) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        SearchResultsHeader()
        Spacer(modifier = Modifier.height(10.dp))
        HymnSearchResultList(
            hymns = hymnSearchResults,
            onHymnClick = onHymnClick,
        )
    }
}

@Preview
@Composable
private fun SearchResultsFramePreview() {
    val hymns = dummyHymnList
    PreviewColumn {
        SearchResultsFrame(
            hymnSearchResults = hymns,
            onHymnClick = { _ -> }
        )
    }
}