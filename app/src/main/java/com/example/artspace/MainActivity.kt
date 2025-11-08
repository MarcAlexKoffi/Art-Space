package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // Index de l’œuvre actuellement affichée
    var currentIndex by remember { mutableIntStateOf(0) }



    val artworks = listOf(
        ArtWork(
            title = "Starry Night",
            artist = "Vincent van Gogh (1889)",
            imageResId = R.drawable.starry_night
        ),
        ArtWork(
            title = "Mona Lisa",
            artist = "Leonardo da Vinci (1503)",
            imageResId = R.drawable.mona_lisa
        ),
        ArtWork(
            title = "The Scream",
            artist = "Edvard Munch (1893)",
            imageResId = R.drawable.the_scream
        )
    )

    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Section Image
        Surface(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 8.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Image(
                painter = painterResource(id = currentArtwork.imageResId),
                contentDescription = currentArtwork.title,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section Texte
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentArtwork.title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = currentArtwork.artist,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section Boutons
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else artworks.lastIndex
            }) {
                Text(text = stringResource(R.string.previous))
            }

            Spacer(modifier = Modifier.width(32.dp))

            Button(onClick = {
                currentIndex = (currentIndex + 1) % artworks.size
            }) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

// Modèle de données pour une œuvre
data class ArtWork(
    val title: String,
    val artist: String,
    val imageResId: Int
)

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
