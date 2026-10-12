package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeSideNavigationRail(
    selectedItem: HomeNavigationItem,
    onItemSelected: (HomeNavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .width(89.dp)
            .fillMaxHeight(),
        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .selectableGroup(),
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeNavigationItems.forEach { item ->
                HomeNavigationAction(
                    item = item,
                    isSelected = item == selectedItem,
                    onClick = { onItemSelected(item) }
                )
            }
        }
    }
}

@Preview(name = "Rail lateral", showBackground = true, widthDp = 180, heightDp = 720)
@Composable
private fun HomeSideNavigationRailPreview() {
    RepertoireTheme {
        HomeSideNavigationRail(
            selectedItem = HomeNavigationItem.Home,
            onItemSelected = {}
        )
    }
}
