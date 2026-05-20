package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.dummyHymn
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components.HymnLyrics
import com.example.algchymns.ui.components.util.PreviewColumn

@Composable
fun HymnLyricsFragment(
    hymn: Hymn,
    modifier: Modifier = Modifier,
) {
    HymnLyrics(
        hymn = hymn,
        modifier = modifier
            .fillMaxSize()
        ,
    )
}


@Preview
@Composable
private fun HymnLyricsFragmentPreview() {
    PreviewColumn {
        HymnLyricsFragment(
            hymn = dummyHymn
        )
    }
}