package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeNavigationItem(
    val icon: ImageVector,
    val contentDescription: String
) {
    Home(Icons.Outlined.Home, "Inicio"),
    Notifications(Icons.Outlined.NotificationsNone, "Notificaciones"),
    Calendar(Icons.Outlined.CalendarMonth, "Calendario"),
    Profile(Icons.Outlined.PersonOutline, "Perfil")
}

internal val HomeNavigationItems = HomeNavigationItem.entries
