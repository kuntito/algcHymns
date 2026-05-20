package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.dummyHymn
import com.example.algchymns.ui.components.util.PreviewColumn

@Composable
fun HymnLyrics(
    hymn: Hymn,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        items(items = hymn.verses) { hv ->
            VerseItem(
                hymnVerse = hv
            )
        }
    }
}

@Preview
@Composable
private fun HymnLyricsPreview() {
    PreviewColumn(
    ) {
        HymnLyrics(
            hymn = dummyHymn,
            modifier = Modifier
                .padding(horizontal = 16.dp)

        )
    }
}