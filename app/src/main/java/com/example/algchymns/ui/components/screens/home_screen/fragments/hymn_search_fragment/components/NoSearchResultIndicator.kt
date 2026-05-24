package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.colorLife
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun NoSearchResultIndicator(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        Text(
            text = "cannot find hymn.",
            style = tsOrion,
            color = colorLife,
        )
    }
}

@Preview
@Composable
private fun NoSearchResultIndicatorPreview() {
    PreviewColumn {
        NoSearchResultIndicator()
    }
}