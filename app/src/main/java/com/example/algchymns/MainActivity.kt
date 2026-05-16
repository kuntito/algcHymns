package com.example.algchymns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.algchymns.data.db.AlgcDb
import com.example.algchymns.data.remote.AlgcApiClient
import com.example.algchymns.data.remote.AlgcApiDataSource
import com.example.algchymns.data.repo.AlgcRepo
import com.example.algchymns.ui.components.screens.home_screen.models.HymnSyncState
import com.example.algchymns.ui.components.util.BackgroundLayer
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

const val algcHymnDebugTag = "algcHymnTag"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AlgcDb.getDatabase(applicationContext)
        val algcDs = AlgcApiDataSource(AlgcApiClient.algcApi)
        val repo = AlgcRepo(
            hymnDao = db.hymnDao(),
            algcDs = algcDs,
        )
        val hymnViewModel: HymnViewModel by viewModels {
            HymnViewModelFactory(
                repo = repo
            )
        }

        enableEdgeToEdge()
        setContent {
            val hymnSyncState by hymnViewModel.hymnSyncState.collectAsState()
            val isHymnsLoaded = hymnSyncState is HymnSyncState.HymnsLoaded

            AlgcHymnsTheme {
                Box(
                    modifier = Modifier
                        .then(appGradientMod)
                        .fillMaxSize()
                ){
                    BackgroundLayer(
                        isHymnsLoaded = isHymnsLoaded
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding(),
                    ) {
                        ScreenNavigation(
                            hymnViewModel = hymnViewModel
                        )
                    }
                }
            }
        }
    }
}