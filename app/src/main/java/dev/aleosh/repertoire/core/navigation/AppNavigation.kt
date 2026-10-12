package dev.aleosh.repertoire.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.aleosh.repertoire.features.home.presentation.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Home.route,
    ) {
        composable(AppScreens.Home.route) {
            HomeScreen()
        }
    }


}