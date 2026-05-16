package com.example.algchymns.ui.components.util.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.colorLife
import com.example.algchymns.ui.theme.tsOrion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppOutlineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val alpha by animateFloatAsState(
        targetValue = if (isPressed) 0.5f else 1f,
        label = "buttonAlpha"
    )

    CompositionLocalProvider(
        LocalRippleConfiguration provides RippleConfiguration(
            color = colorLife,
        )
    ) {
        OutlinedButton(
            border = BorderStroke(width = 1.dp, color = colorHoly),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colorHoly,
            ),
            interactionSource = interactionSource,
            onClick = onClick,
            modifier = modifier
                .alpha(alpha)
            ,
        ) {
            Text(
                text = text,
                style = tsOrion
            )
        }
    }
}

@Preview
@Composable
private fun AppOutlineButtonPreview() {
    PreviewColumn {
        AppOutlineButton(
            text = "retry download",
            onClick = {},
        )
    }
}