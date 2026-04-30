package com.example.algchymns.ui.components.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.ui.components.util.ClickableSurface
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.colorIju
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(
                    color = Color(0xFF3C3692)
                        .copy(
                            alpha = 0.9f
                        ),
                    shape = RoundedCornerShape(16.dp)
                )
                .height(40.dp)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
            ,
        ) {
            HymnListNumber(hymnNumber)
            VerticalDivider(
                color = colorHoly,
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