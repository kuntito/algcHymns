package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorCreed
import com.example.algchymns.ui.theme.colorTestimony
import com.example.algchymns.ui.theme.colorWorship
import com.example.algchymns.ui.theme.tsOrionMono


@Composable
fun VerseHeader(
    verseOrder: Int,
    modifier: Modifier = Modifier,
) {
    VerseHeaderBase(
        label = "verse $verseOrder",
        color = colorWorship,
        modifier = modifier,
    )
}

@Composable
fun ChorusHeader(
    modifier: Modifier = Modifier,
) {
    VerseHeaderBase(
        label = "chorus",
        color = colorTestimony,
        modifier = modifier,
    )
}

@Composable
fun VerseHeaderBase(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .alpha(0.8f)
        ,
    ) {
        Text(
            text = label,
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
        VerseHeader(
            verseOrder = 1
        )
        ChorusHeader()
    }
}