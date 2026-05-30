package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.dummyChorus
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorTestimony
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun HymnChorusLi(
    modifier: Modifier = Modifier,
    chorusLines: List<String>
) {
    Column(
        modifier = modifier
        ,
    ) {
        ChorusHeader()
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
            ,
        ) {
            chorusLines.map { cl ->
                Text(
                    text = cl,
                    style = tsOrion,
                    color = colorTestimony,
                    fontStyle = FontStyle.Italic,
                )
            }
        }
    }
}

@Preview
@Composable
private fun HymnChorusLiPreview() {
    val chorusLines = dummyChorus.verseLines
    PreviewColumn {
        HymnChorusLi(
            chorusLines = chorusLines,
        )
    }
}