package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.dummyHymn
import com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components.GradientLine
import com.example.algchymns.ui.components.util.ClickableSurface
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorCreed
import com.example.algchymns.ui.theme.colorLife
import com.example.algchymns.ui.theme.colorTestimony
import com.example.algchymns.ui.theme.colorWorship
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun RecentSearchLi(
    modifier: Modifier = Modifier,
    hymn: Hymn,
    onClick: () -> Unit,
) {
    ClickableSurface(
        onClick = onClick,
        isRippleBounded = true,
    ) {
        Column(
            modifier = modifier,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(39.dp)
                ,
            ) {
                Text(
                    text = hymn.title,
                    style = tsOrion,
                    color = colorTestimony,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            GradientLine(
                colorStart = colorTestimony
                    .copy(
                        alpha = 0.6f
                    ),
                colorTrail = colorCreed,
            )
        }
    }
}

@Preview
@Composable
private fun HymnSearchLiPreview() {
    PreviewColumn {
        RecentSearchLi(
            hymn = dummyHymn,
            onClick = {},
        )
    }
}