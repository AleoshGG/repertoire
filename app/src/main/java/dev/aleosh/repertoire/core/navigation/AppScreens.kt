package dev.aleosh.repertoire.core.navigation

sealed class AppScreens(val route: String) {
    object Home : AppScreens("home_screen")
}