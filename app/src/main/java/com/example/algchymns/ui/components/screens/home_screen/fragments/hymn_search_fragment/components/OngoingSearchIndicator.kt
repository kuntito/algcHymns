package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly

@Composable
fun OngoingSearchIndicator(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        CircularProgressIndicator(
            color = colorHoly,
            strokeWidth = 2.dp,
        )
    }
}

@Preview
@Composable
private fun OngoingSearchIndicatorPreview() {
    PreviewColumn {
        OngoingSearchIndicator()
    }
}