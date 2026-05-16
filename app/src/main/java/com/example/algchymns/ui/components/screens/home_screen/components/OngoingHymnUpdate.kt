package com.example.algchymns.ui.components.screens.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.algchymns.R
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.blinkable
import com.example.algchymns.ui.theme.colorIju
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun OngoingHymnUpdate(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_update),
                contentDescription = null,
                tint = colorIju,
                modifier = Modifier
                    .size(80.dp)
                ,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "updating hymns...",
                textAlign = TextAlign.Center,
                style = tsOrion
                    .copy(
                        fontSize = 24.sp
                    ),
                modifier = Modifier
                    .then(
                        Modifier.blinkable()
                    )
            )
        }
    }
}

@Preview
@Composable
private fun OngoingHymnUpdatePreview() {
    PreviewColumn(
        showWatermark = false
    ) {
        OngoingHymnUpdate()
    }
}