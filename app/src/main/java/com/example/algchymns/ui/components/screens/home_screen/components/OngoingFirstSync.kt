package com.example.algchymns.ui.components.screens.home_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.blinkable
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun OngoingFirstSync(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        Text(
            text = "downloading hymns...",
            textAlign = TextAlign.Center,
            style = tsOrion
                .copy(
                    fontSize = 24.sp,
                ),
            modifier = Modifier
                .then(
                    Modifier.blinkable()
                )
        )
    }
}

@Preview
@Composable
private fun OngoingFirstSyncPreview() {
    PreviewColumn {
        OngoingFirstSync()
    }
}