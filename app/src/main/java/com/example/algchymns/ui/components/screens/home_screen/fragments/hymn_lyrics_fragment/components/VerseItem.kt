package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.HymnVerse
import com.example.algchymns.data.remote.response_models.dummyChorus
import com.example.algchymns.data.remote.response_models.dummyHymnVerse
import com.example.algchymns.ui.components.util.PreviewColumn

@Composable
fun VerseItem(
    modifier: Modifier = Modifier,
    hymnVerse: HymnVerse,
) {
    Column(
        modifier = modifier
        ,
    ) {
        VerseHeader(
            hymnVerse = hymnVerse
        )
        Spacer(modifier = Modifier.height(10.dp))
        VerseLyrics(
            verse = hymnVerse,
        )
    }
}


@Preview
@Composable
private fun VerseItemPreview() {
    PreviewColumn {
        VerseItem(
            hymnVerse = dummyHymnVerse
        )
        VerseItem(
            hymnVerse = dummyChorus
        )
    }
}