package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_lyrics_fragment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorCreed
import com.example.algchymns.ui.theme.colorWorship

@Composable
fun GradientLine(
    colorStart: Color,
    colorTrail: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to colorStart,
                        0.85f to colorTrail
                            .copy(
                                alpha = 0.0f
                            ),
                    )
                )
            )
    )
}

@Preview
@Composable
private fun GradientLinePreview() {
    PreviewColumn() {
        GradientLine(
            colorStart = colorWorship,
            colorTrail = colorCreed,
        )
    }
}