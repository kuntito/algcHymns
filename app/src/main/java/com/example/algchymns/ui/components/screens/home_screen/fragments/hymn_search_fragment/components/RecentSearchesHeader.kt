package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_search_fragment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.R
import com.example.algchymns.ui.components.util.AppIconButton
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun RecentSearchesHeader(
    modifier: Modifier = Modifier,
) {
    val onClearRecentsClick = {}
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
        ,
    ) {
        Text(
            text = "recent searches",
            style = tsOrion,
            color = colorHoly,
        )
        AppIconButton(
            iconRes = R.drawable.ic_x_badge,
            size = 16,
            onClick = onClearRecentsClick,
        )
    }
}

@Preview
@Composable
private fun RecentSearchesHeaderPreview() {
    PreviewColumn {
        RecentSearchesHeader()
    }
}