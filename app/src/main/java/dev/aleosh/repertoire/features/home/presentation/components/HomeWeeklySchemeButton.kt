package dev.aleosh.repertoire.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.aleosh.repertoire.R
import dev.aleosh.repertoire.core.theme.RepertoireTheme

@Composable
fun HomeWeeklySchemeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(164.dp),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Capa de fondo: Imagen
            Image(
                painter = painterResource(id = R.drawable.home_schema_01),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                // Agregamos un ColorFilter para oscurecer/teñir la imagen
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                    androidx.compose.ui.graphics.Color.Black.copy(alpha = 0.3f),
                    blendMode = androidx.compose.ui.graphics.BlendMode.Darken
                )
            )
            
            // Capa de contenido: Texto y botón
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp, vertical = 22.dp)
            ) {
                Text(
                    text = "Esquema\nsemanal",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 34.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ver",
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
}

@Preview(name = "Esquema semanal", showBackground = true, widthDp = 428)
@Composable
private fun HomeWeeklySchemeButtonPreview() {
    RepertoireTheme {
        HomeWeeklySchemeButton(
            onClick = {},
            modifier = Modifier.padding(32.dp)
        )
    }
}
