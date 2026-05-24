package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun SearchResultsHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
        ,
    ) {
        Text(
            text = "search results",
            style = tsOrion,
            color = colorHoly,
        )
    }
}

@Preview
@Composable
private fun SearchResultsHeaderPreview() {
    PreviewColumn {
        SearchResultsHeader()
    }
}