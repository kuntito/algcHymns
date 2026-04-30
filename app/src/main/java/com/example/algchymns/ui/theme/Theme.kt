package com.example.algchymns.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val colorScheme = darkColorScheme(
    background = colorCreed, // default app bg

)

@Composable
fun AlgcHymnsTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = colorScheme

    // sets up status bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorIju.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }


    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}