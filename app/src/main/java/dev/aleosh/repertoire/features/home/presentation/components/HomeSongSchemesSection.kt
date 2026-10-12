package dev.aleosh.repertoire.features.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.aleosh.repertoire.R
import dev.aleosh.repertoire.core.theme.RepertoireTheme

data class SongSchemeItem(
    val title: String,
    @DrawableRes val imageRes: Int
)

@Composable
fun HomeSongSchemesSection(
    onSchemeClick: (String) -> Unit,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier,
    schemes: List<SongSchemeItem> = DefaultSongSchemes
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
            items(
                items = schemes,
                key = { scheme -> scheme.title }
            ) { scheme ->
                SongSchemeButton(
                    title = scheme.title,
                    imageRes = scheme.imageRes,
                    onClick = { onSchemeClick(scheme.title) }
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
    @DrawableRes imageRes: Int,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .width(112.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(
                    Color.Black.copy(alpha = 0.3f), // Oscurecemos al 50%
                    blendMode = BlendMode.Darken
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private val DefaultSongSchemes = listOf(
    SongSchemeItem("Adviento", R.drawable.home_schema_02),
    SongSchemeItem("Navidad", R.drawable.home_schema_04),
    SongSchemeItem("Difunto", R.drawable.home_schema_03)
)

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
