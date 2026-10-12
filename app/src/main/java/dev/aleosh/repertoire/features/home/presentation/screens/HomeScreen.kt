package dev.aleosh.repertoire.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.aleosh.repertoire.features.home.presentation.components.HomeAdaptiveNavigationLayout
import dev.aleosh.repertoire.features.home.presentation.components.HomeHeader
import dev.aleosh.repertoire.features.home.presentation.components.HomeNavigationItem

@Composable
fun HomeScreen() {
    var selectedItem by rememberSaveable {
        mutableStateOf(HomeNavigationItem.Home)
    }

    HomeAdaptiveNavigationLayout(
        selectedItem = selectedItem,
        onItemSelected = { selectedItem = it }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            HomeHeader(
                userName = "Alexis",
                onSettingsClick = {}
            )
        }
    }
}
