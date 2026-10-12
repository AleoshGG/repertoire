package dev.aleosh.repertoire.features.home.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeAdaptiveNavigationLayout(
    selectedItem: HomeNavigationItem,
    onItemSelected: (HomeNavigationItem) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val isLandscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        Row(modifier = modifier.fillMaxSize()) {
            HomeSideNavigationRail(
                selectedItem = selectedItem,
                onItemSelected = onItemSelected
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .safeDrawingPadding()
            ) {
                content()
            }
        }
    } else {
        Scaffold(
            modifier = modifier,
            bottomBar = {
                HomeBottomNavigationBar(
                    selectedItem = selectedItem,
                    onItemSelected = onItemSelected
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                content()
            }
        }
    }
}

@Preview(name = "Navegación vertical", showBackground = true, widthDp = 428, heightDp = 900)
@Preview(name = "Navegación horizontal", showBackground = true, widthDp = 1280, heightDp = 800)
@Composable
private fun HomeAdaptiveNavigationLayoutPreview() {
    RepertoireTheme {
        HomeAdaptiveNavigationLayout(
            selectedItem = HomeNavigationItem.Home,
            onItemSelected = {}
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {}
        }
    }
}
