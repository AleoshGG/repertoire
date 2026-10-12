package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
internal fun HomeNavigationAction(
    item: HomeNavigationItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val containerColor by animateColorAsState(
        targetValue = if (isSelected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            Color.Transparent
        },
        animationSpec = tween(durationMillis = 160),
        label = "navigation container color"
    )

    Box(
        modifier = Modifier
            .size(width = HomeNavigationItemWidth, height = HomeNavigationTouchTarget)
            .clip(HomeNavigationItemShape)
            .background(containerColor)
            .selectable(
                selected = isSelected,
                onClick = onClick,
                role = Role.Tab
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.contentDescription,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

internal val HomeNavigationItemWidth = 56.dp
private val HomeNavigationTouchTarget = 48.dp
private val HomeNavigationItemShape = RoundedCornerShape(16.dp)
