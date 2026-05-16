package com.example.algchymns.ui.components.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInCubic
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.algchymns.R

@Composable
fun BackgroundLayer(
    modifier: Modifier = Modifier,
    isHymnsLoaded: Boolean,
) {
    Box(
        modifier = modifier,
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val animSpec = tween<Float>(600)
            AnimatedVisibility(
                visible = isHymnsLoaded,
                enter = scaleIn(
                    animationSpec = tween(
                        600,
                        easing = EaseOutCubic
                    ),
                    initialScale = 0f,
                    transformOrigin = TransformOrigin.Center
                ) + fadeIn(
                    tween(600)
                ),
                exit = scaleOut(
                    animationSpec = tween(
                        600,
                        easing = EaseInCubic
                    ),
                    targetScale = 0f,
                    transformOrigin = TransformOrigin.Center
                ) + fadeOut(
                    tween(600)
                )
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
        }
        ParticleLayer(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}