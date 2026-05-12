package com.example.algchymns.ui.components.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.algchymns.R

@Composable
fun BackgroundLayer(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(
                    R.drawable.algc_logo,
                ),
                contentDescription = null,
                modifier = Modifier
                    .alpha(0.15f)
                    .size(240.dp)
            )
        }
        ParticleLayer(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}