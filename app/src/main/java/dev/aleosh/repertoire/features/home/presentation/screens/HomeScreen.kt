package dev.aleosh.repertoire.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.aleosh.repertoire.features.home.presentation.components.HomeAdaptiveNavigationLayout
import dev.aleosh.repertoire.features.home.presentation.components.HomeDirectorSection
import dev.aleosh.repertoire.features.home.presentation.components.HomeHeader
import dev.aleosh.repertoire.features.home.presentation.components.HomeNavigationItem
import dev.aleosh.repertoire.features.home.presentation.components.HomeSearchBar
import dev.aleosh.repertoire.features.home.presentation.components.HomeSongSchemesSection
import dev.aleosh.repertoire.features.home.presentation.components.HomeWeeklySchemeButton

@Composable
fun HomeScreen() {
    var selectedItem by rememberSaveable {
        mutableStateOf(HomeNavigationItem.Home)
    }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val searchResults = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            emptyList()
        } else {
            HomeSearchOptions.filter { option ->
                option.contains(searchQuery, ignoreCase = true)
            }
        }
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(
                    start = 32.dp,
                    top = 24.dp,
                    end = 32.dp,
                    bottom = 24.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    HomeSearchBar(
                        query = searchQuery,
                        results = searchResults,
                        onQueryChange = { searchQuery = it },
                        onResultClick = { searchQuery = "" },
                        onVoiceSearchClick = {},
                        modifier = Modifier.homeContentWidth()
                    )
                }
                item {
                    HomeWeeklySchemeButton(
                        onClick = {},
                        modifier = Modifier
                            .homeContentWidth()
                            .padding(top = 18.dp)
                    )
                }
                item {
                    HomeDirectorSection(
                        onAddSongClick = {},
                        onFirstOptionClick = {},
                        onSecondOptionClick = {},
                        modifier = Modifier
                            .homeContentWidth()
                            .padding(top = 32.dp)
                    )
                }
                item {
                    HomeSongSchemesSection(
                        onSchemeClick = {},
                        onSeeAllClick = {},
                        modifier = Modifier
                            .homeContentWidth()
                            .padding(top = 32.dp)
                    )
                }
            }
        }
    }
}

private fun Modifier.homeContentWidth(): Modifier =
    widthIn(max = 600.dp).fillMaxWidth()

private val HomeSearchOptions = listOf(
    "Esquema semanal",
    "Añadir canto",
    "Primera opción del director",
    "Segunda opción del director",
    "Adviento",
    "Navidad",
    "Difunto"
)
