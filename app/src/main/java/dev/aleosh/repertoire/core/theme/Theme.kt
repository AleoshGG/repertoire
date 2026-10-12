package dev.aleosh.repertoire.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val RepertoireColorScheme = darkColorScheme(
    primary = RepertoirePink,
    onPrimary = RepertoireOnPink,
    primaryContainer = RepertoireSelected,
    onPrimaryContainer = RepertoirePink,
    secondary = RepertoirePink,
    onSecondary = RepertoireOnPink,
    secondaryContainer = RepertoireSelected,
    onSecondaryContainer = RepertoirePink,
    tertiary = RepertoirePink,
    onTertiary = RepertoireOnPink,
    background = RepertoireBackground,
    onBackground = RepertoireOnSurface,
    surface = RepertoireSurface,
    onSurface = RepertoireOnSurface,
    surfaceVariant = RepertoireSurfaceVariant,
    onSurfaceVariant = RepertoireOnSurfaceVariant,
    surfaceContainerLowest = RepertoireSurfaceLowest,
    surfaceContainerLow = RepertoireBackground,
    surfaceContainer = RepertoireSurface,
    surfaceContainerHigh = RepertoireSurfaceVariant,
    surfaceContainerHighest = RepertoireSurfaceVariant,
    outline = RepertoireOutline,
    error = RepertoireError,
    onError = RepertoireOnError,
    scrim = RepertoireSurfaceLowest
)

@Composable
fun RepertoireTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = RepertoireColorScheme,
        typography = AppTypography,
        content = content
    )
}
