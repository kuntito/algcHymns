package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.HymnVerse
import com.example.algchymns.data.remote.response_models.VerseType
import com.example.algchymns.data.remote.response_models.dummyChorus
import com.example.algchymns.data.remote.response_models.dummyHymnVerse
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorLife
import com.example.algchymns.ui.theme.colorTestimony
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun VerseLyrics(
    modifier: Modifier = Modifier,
    verse: HymnVerse,
) {
    val color = if (verse.verseType == VerseType.VERSE) colorLife else colorTestimony
    val fontStyle = if (verse.verseType == VerseType.VERSE) FontStyle.Normal else FontStyle.Italic

    val verseLines = verse.verseLines
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
            .fillMaxWidth()
        ,
    ) {
        verseLines.map { vl ->
            Text(
                text = vl,
                style = tsOrion,
                color = color,
                fontStyle = fontStyle,
            )
        }
    }
}

@Preview
@Composable
private fun VerseLyricsPreview() {
    val dummyHymnVerse = dummyHymnVerse
    val dummyHymnChorus = dummyChorus
    PreviewColumn() {
        VerseLyrics(
            verse = dummyHymnVerse,
        )
        VerseLyrics(
            verse = dummyChorus,
        )
    }
}