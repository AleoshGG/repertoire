package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeBottomNavigationBar(
    selectedItem: HomeNavigationItem,
    onItemSelected: (HomeNavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        shadowElevation = 2.dp
    ) {
        Column {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(NavigationBarContentHeight),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.selectableGroup(),
                    horizontalArrangement = Arrangement.spacedBy(navigationItemGap(maxWidth)),
                    verticalAlignment = Alignment.CenterVertically
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
            Spacer(
                modifier = Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars)
            )
        }
    }
}

private fun navigationItemGap(availableWidth: Dp): Dp {
    val designWidth = availableWidth.coerceAtMost(FigmaNavigationWidth)
    return ((designWidth - NavigationItemsWidth - NavigationHorizontalPadding * 2) /
        NavigationItemGapCount).coerceIn(MinimumItemGap, FigmaItemGap)
}

private val NavigationBarContentHeight = 64.dp
private val NavigationItemsWidth = HomeNavigationItemWidth * HomeNavigationItems.size
private const val NavigationItemGapCount = 3
private val NavigationHorizontalPadding = 24.dp
private val MinimumItemGap = 8.dp
private val FigmaItemGap = 52.dp
private val FigmaNavigationWidth = 428.dp

@Preview(name = "Barra inferior", showBackground = true, widthDp = 428)
@Composable
private fun HomeBottomNavigationBarPreview() {
    RepertoireTheme {
        HomeBottomNavigationBar(
            selectedItem = HomeNavigationItem.Home,
            onItemSelected = {}
        )
    }
}
