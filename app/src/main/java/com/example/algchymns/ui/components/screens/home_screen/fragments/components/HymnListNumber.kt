package com.example.algchymns.ui.components.screens.home_screen.fragments.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorLife
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun HymnListNumber(
    number: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        style = tsOrion,
        color = colorLife
            .copy(
                alpha = 0.6f
            ),
        text = parseNumber(number),
        modifier = modifier
        ,
    )
}

// TODO docstring..
fun parseNumber(number: Int): String {
    if (number < 10) {
        return "0${number}"
    }

    return number.toString()
}

@Preview
@Composable
private fun HymnListNumberPreview() {
    PreviewColumn {
        HymnListNumber(1)
    }
}