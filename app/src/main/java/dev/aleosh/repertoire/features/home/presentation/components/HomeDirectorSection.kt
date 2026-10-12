package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeDirectorSection(
    onAddSongClick: () -> Unit,
    onFirstOptionClick: () -> Unit,
    onSecondOptionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(
            title = "Espacio para el director",
            subtitle = "Opciones recurrentes como director musical"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            DirectorButton(
                text = "Añadir\nCanto",
                onClick = onAddSongClick,
                modifier = Modifier
                    .weight(0.45f)
                    .height(148.dp),
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
            Column(
                modifier = Modifier.weight(0.55f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                DirectorButton(
                    text = "Opción",
                    onClick = onFirstOptionClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                )
                DirectorButton(
                    text = "Opción",
                    onClick = onSecondOptionClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            }
        }
    }
}

@Composable
private fun DirectorButton(
    text: String,
    onClick: () -> Unit,
    containerColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = containerColor
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 28.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
internal fun SectionHeader(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = subtitle,
            modifier = Modifier.padding(top = 6.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(name = "Espacio para el director", showBackground = true, widthDp = 428)
@Composable
private fun HomeDirectorSectionPreview() {
    RepertoireTheme {
        HomeDirectorSection(
            onAddSongClick = {},
            onFirstOptionClick = {},
            onSecondOptionClick = {},
            modifier = Modifier.padding(32.dp)
        )
    }
}
