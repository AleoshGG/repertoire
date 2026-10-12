package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeHeader(
    userName: String,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
    avatarUrl: String? = null
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceContainerLowest
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserAvatar(
                userName = userName,
                avatarUrl = avatarUrl
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Hola $userName",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = onSettingsClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Configuración",
                    modifier = Modifier.size(28.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun UserAvatar(
    userName: String,
    avatarUrl: String?
) {
    val avatarModifier = Modifier
        .size(48.dp)
        .clip(CircleShape)

    if (avatarUrl.isNullOrBlank()) {
        AvatarFallback(
            initial = userName.firstOrNull()?.uppercaseChar()?.toString().orEmpty(),
            modifier = avatarModifier
        )
    } else {
        AsyncImage(
            model = avatarUrl,
            contentDescription = "Foto de perfil de $userName",
            modifier = avatarModifier,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun AvatarFallback(
    initial: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(name = "Header teléfono", showBackground = true, widthDp = 428)
@Composable
private fun HomeHeaderPreview() {
    RepertoireTheme {
        HomeHeader(
            userName = "Alexis",
            onSettingsClick = {}
        )
    }
}
