package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import core.model.response.PublicationResponse

@Composable
fun Publication(
    publication: PublicationResponse
) {
    Spacer(modifier = Modifier.size(10.dp))
    Column (
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .border(1.dp, MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            Spacer(modifier = Modifier.size(15.dp))
            UserLabel(username = publication.authorName)
        }

        Spacer(modifier = Modifier.size(10.dp))
        Row(
            Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            FText(text = publication.body, fontSize = 11)
        }

        Spacer(modifier = Modifier.size(10.dp))
//        AsyncImage(
//            model = "https://img.freepik.com/free-photo/ultra-detailed-nebula-abstract-wallpaper-4_1562-749.jpg",
//            contentDescription = "Photo of the year",
//            modifier = Modifier
//                .size(width = 350.dp, height = 230.dp)
//        )
        Row {
            Spacer(modifier = Modifier.width(15.dp))
            InteractionBar()
        }
    }
}