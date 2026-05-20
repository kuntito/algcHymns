package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.HymnVerse
import com.example.algchymns.data.remote.response_models.VerseType
import com.example.algchymns.data.remote.response_models.dummyChorus
import com.example.algchymns.data.remote.response_models.dummyHymnVerse
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorCreed
import com.example.algchymns.ui.theme.colorTestimony
import com.example.algchymns.ui.theme.colorWorship
import com.example.algchymns.ui.theme.tsOrionMono

@Composable
fun VerseHeader(
    hymnVerse: HymnVerse,
    modifier: Modifier = Modifier,
) {
    val isVerse = hymnVerse.verseType == VerseType.VERSE
    val text = if (isVerse) {
        "verse ${hymnVerse.verseOrder}"
    } else {
        "chorus"
    }
    val color = if (isVerse) colorWorship else colorTestimony
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .alpha(0.5f)
        ,
    ) {
        Text(
            text = text,
            style = tsOrionMono,
            color = color,
        )
        Spacer(modifier = Modifier.width(10.dp))
        GradientLine(
            colorStart = color,
            colorTrail = colorCreed,
        )
    }
}

@Preview
@Composable
private fun VerseHeaderPreview() {
    PreviewColumn {
        VerseHeader(hymnVerse = dummyHymnVerse)
        VerseHeader(hymnVerse = dummyChorus)
    }
}