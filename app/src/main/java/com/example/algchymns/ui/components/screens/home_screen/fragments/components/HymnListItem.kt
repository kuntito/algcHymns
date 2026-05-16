package com.example.algchymns.ui.components.screens.home_screen.fragments.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.ui.components.util.ClickableSurface
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun HymnListItem(
    hymnNumber: Int,
    hymnTitle: String,
    modifier: Modifier = Modifier,
) {
    ClickableSurface(
        onClick = {},
        isRippleBounded = true,
    ) {
        val itemShape = RoundedCornerShape(16.dp)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .alpha(0.93f)
                .background(
                    color = Color(0xFF3C3692)
                        .copy(
                            alpha = 0.9f
                        ),
                    shape = itemShape,
                )
                .height(48.dp)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
            ,
        ) {
            HymnListNumber(hymnNumber)
            VerticalDivider(
                color = colorHoly
                    .copy(
                        alpha = 0.5f
                    ),
                modifier = Modifier
                    .height(12.dp),
            )
            Text(
                text = hymnTitle,
                style = tsOrion,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
private fun HymnListItemPreview() {
    PreviewColumn {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            HymnListItem(
                1,
                "Great is Thy Faithfulness "
            )
       }
    }
}