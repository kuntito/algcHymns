package com.example.algchymns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import com.example.algchymns.ui.components.util.ParticleLayer
import com.example.algchymns.ui.theme.AlgcHymnsTheme

val appGradientMod = Modifier
    .background(
        brush = Brush.linearGradient(
            colorStops = arrayOf(
                0.0f to Color(0xFF00003F),
                0.6f to Color(0xFF010184),
                1.0f to Color(0xFF01019D),
            ),
            start = Offset(0f, 0f),
            end = Offset(0f, Float.POSITIVE_INFINITY)

        )
    )
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlgcHymnsTheme {
                Box(
                    modifier = Modifier
                        .then(appGradientMod)
                        .fillMaxSize()
                ){
                    ParticleLayer(
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(1f)
                    )
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = Color.Transparent
                    ) { innerPadding ->

                    }
                }
            }
        }
    }
}