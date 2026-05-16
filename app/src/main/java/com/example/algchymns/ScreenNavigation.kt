package com.example.algchymns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.algchymns.ui.components.screens.HymnSearchScreenRoot
import com.example.algchymns.ui.components.screens.home_screen.HomeScreenRoot
import kotlinx.serialization.Serializable

sealed class AppScreens {
    @Serializable
    object HomeScreen

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
        startDestination = AppScreens.HomeScreen,
        modifier = modifier
            .fillMaxSize()
    ) {
        composable<AppScreens.HomeScreen>{
            HomeScreenRoot(
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