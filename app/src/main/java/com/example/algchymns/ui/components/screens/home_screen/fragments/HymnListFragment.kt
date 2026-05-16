package com.example.algchymns.ui.components.screens.home_screen.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.data.remote.response_models.dummyHymnList
import com.example.algchymns.ui.components.screens.home_screen.components.HymnDownloadError
import com.example.algchymns.ui.components.screens.home_screen.components.OngoingHymnDownload
import com.example.algchymns.ui.components.screens.home_screen.components.OngoingHymnUpdate
import com.example.algchymns.ui.components.screens.home_screen.models.HymnSyncState
import com.example.algchymns.ui.components.screens.home_screen.fragments.components.HymnList
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.buttons.AppOutlineButton

@Composable
fun HymnListFragment(
    hymnSyncState: HymnSyncState,
    retryHymnsDownload: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
        ,
    ) {
        when(hymnSyncState) {
            HymnSyncState.Idle -> {

            }
            HymnSyncState.DownloadingHymns -> {
                OngoingHymnDownload()
            }
            HymnSyncState.HymnDownloadError -> {
                HymnDownloadError(
                    retryHymnsDownload = retryHymnsDownload,
                )
            }
            is HymnSyncState.HymnsLoaded -> {
                HymnList(
                    hymnItems = hymnSyncState.hymns
                )
            }
            HymnSyncState.HymnsUpdate -> {
                OngoingHymnUpdate()
            }
        }
    }
}

@Preview
@Composable
private fun HymnListFragmentPreview() {
    var hymnSyncState: HymnSyncState by remember{
        mutableStateOf(HymnSyncState.Idle)
    }

    fun toggleSyncState() {
        when(hymnSyncState) {
            HymnSyncState.Idle -> {
                hymnSyncState = HymnSyncState.DownloadingHymns
            }
            HymnSyncState.DownloadingHymns -> {
                hymnSyncState = HymnSyncState.HymnDownloadError
            }
            HymnSyncState.HymnDownloadError -> {
                hymnSyncState = HymnSyncState.HymnsLoaded(
                    hymns = dummyHymnList
                )
            }
            is HymnSyncState.HymnsLoaded -> {
                hymnSyncState = HymnSyncState.HymnsUpdate
            }
            HymnSyncState.HymnsUpdate -> {
                hymnSyncState = HymnSyncState.Idle
            }
        }
    }
    PreviewColumn(
        showWatermark = hymnSyncState is HymnSyncState.HymnsLoaded
    ){
        AppOutlineButton(
            text = "toggle hymn sync state",
            onClick = ::toggleSyncState
        )

        HymnListFragment(
            retryHymnsDownload = {},
            hymnSyncState = hymnSyncState,
        )
    }
}