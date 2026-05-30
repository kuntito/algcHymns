package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.dummyHymnVerse
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorLife
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun HymnVerseLi(
    modifier: Modifier = Modifier,
    verseNumber: Int,
    verseLines: List<String>
) {
    Column(
        modifier = modifier
    ) {
        VerseHeader(
            verseOrder = verseNumber,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
            ,
        ) {
            verseLines.map { vl ->
                Text(
                    text = vl,
                    style = tsOrion,
                    color = colorLife,
                )
            }
        }
    }
}


@Preview
@Composable
private fun HymnVerseLiPreview() {
    val verseLines = dummyHymnVerse.verseLines
    PreviewColumn {
        HymnVerseLi(
            verseNumber = 1,
            verseLines = verseLines
        )
    }
}