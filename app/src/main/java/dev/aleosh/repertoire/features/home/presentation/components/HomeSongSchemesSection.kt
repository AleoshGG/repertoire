package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeSongSchemesSection(
    onSchemeClick: (String) -> Unit,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier,
    schemes: List<String> = DefaultSongSchemes
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(
            title = "Esquemas de cantos",
            subtitle = "Encuentra los esquemas ordenados de diferentes formas"
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(end = 16.dp)
        ) {
            itemsIndexed(
                items = schemes,
                key = { _, scheme -> scheme }
            ) { index, scheme ->
                SongSchemeButton(
                    title = scheme,
                    onClick = { onSchemeClick(scheme) },
                    useAccentContainer = index % 2 != 0
                )
            }
        }
        TextButton(
            onClick = onSeeAllClick,
            modifier = Modifier.padding(top = 2.dp),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Ver todos",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun SongSchemeButton(
    title: String,
    onClick: () -> Unit,
    useAccentContainer: Boolean
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .width(112.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        color = if (useAccentContainer) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceContainerHigh
        }
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

private val DefaultSongSchemes = listOf("Adviento", "Navidad", "Difunto")

@Preview(name = "Esquemas de cantos", showBackground = true, widthDp = 428)
@Composable
private fun HomeSongSchemesSectionPreview() {
    RepertoireTheme {
        HomeSongSchemesSection(
            onSchemeClick = {},
            onSeeAllClick = {},
            modifier = Modifier.padding(32.dp)
        )
    }
}
