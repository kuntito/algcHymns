package com.example.algchymns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import com.example.algchymns.data.db.AlgcDb
import com.example.algchymns.data.remote.AlgcApiClient
import com.example.algchymns.data.remote.AlgcApiDataSource
import com.example.algchymns.data.repo.AlgcRepo
import com.example.algchymns.ui.components.util.ParticleLayer
import com.example.algchymns.ui.theme.AlgcHymnsTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
            AlgcHymnsTheme {
                Box(
                    modifier = Modifier
                        .then(appGradientMod)
                        .fillMaxSize()
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
                                .alpha(0.2f)
                                .size(240.dp)
                        )
                    }
                    ParticleLayer(
                        modifier = Modifier
                            .fillMaxSize()
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