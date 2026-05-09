package com.example.algchymns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.algchymns.ui.components.screens.HymnListScreenRoot
import com.example.algchymns.ui.components.screens.HymnSearchScreenRoot
import kotlinx.serialization.Serializable

sealed class AppScreens {
    @Serializable
    object HymnListScreen

    @Serializable
    object HymnSearchScreen
}

@Composable
fun ScreenNavigation(
    modifier: Modifier = Modifier,
    hymnViewModel: HymnViewModel,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HymnListScreen,
        modifier = modifier
            .fillMaxSize()
    ) {
        composable<AppScreens.HymnListScreen>{
            HymnListScreenRoot(
                hymnViewModel = hymnViewModel,
            )
        }
        composable<AppScreens.HymnSearchScreen>{
            HymnSearchScreenRoot(
                hymnViewModel = hymnViewModel,
            )
        }
    }
}