package com.example.algchymns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.algchymns.ui.components.util.ParticleLayer
import com.example.algchymns.ui.theme.AlgcHymnsTheme
import com.example.algchymns.ui.theme.colorCreed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlgcHymnsTheme {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colorStops = arrayOf(
                                    0.0f to Color(0xFF00003F),
                                    0.6f to Color(0xFF00003F),
                                    1.0f to Color(0xFF01019D),
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)

                            )
                        )
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