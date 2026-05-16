package com.example.algchymns.ui.components.screens.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.R
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.buttons.AppOutlineButton
import com.example.algchymns.ui.components.util.buttons.AppSnackBar
import com.example.algchymns.ui.theme.colorDebit
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.colorLife
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HymnDownloadError(
    retryHymnsDownload: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.TopCenter, // for snack bar
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        val snackbarHostState = remember {
            SnackbarHostState()
        }

        val coroutineScope = rememberCoroutineScope()
        val displayErrorSnackBar = {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(
                    message = "couldn't download hymns",
                    duration = SnackbarDuration.Short,
                )
            }
        }

        LaunchedEffect(Unit) {
            displayErrorSnackBar()
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
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
                    painter = painterResource(R.drawable.ic_retry),
                    contentDescription = null,
                    tint = colorHoly,
                    modifier = Modifier
                        .size(80.dp)
                    ,
                )
                Spacer(modifier = Modifier.height(16.dp))
                AppOutlineButton(
                    text = "retry download",
                    onClick = retryHymnsDownload,
                )
            }
        }
        SnackbarHost(
            hostState = snackbarHostState,
            snackbar = { data ->
                AppSnackBar(
                    text = data.visuals.message,
                    bgColor = colorDebit,
                    textColor = colorLife,
                )
            }
        )
    }
}

@Preview
@Composable
private fun HymnDownloadErrorPreview() {
    PreviewColumn(
        showWatermark = false
    ) {
        HymnDownloadError(
            retryHymnsDownload = {},
        )
    }
}