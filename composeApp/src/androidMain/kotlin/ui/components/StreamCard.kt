package ui.components

import FifthEssenceScreens
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import core.model.response.StreamResponse

@Composable
fun StreamCard(
    stream: StreamResponse,
    navHostController: NavHostController
) {
    Button(
        onClick = {
            navHostController.navigate(FifthEssenceScreens.STREAM_VIEW.name + "/${stream.id}")
        },
        modifier = Modifier
            .width(170.dp)
            .height(160.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.large
            ),
        contentPadding = PaddingValues(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https://img.freepik.com/free-photo/ultra-detailed-nebula-abstract-wallpaper-4_1562-749.jpg",
                contentDescription = "Photo of the year",
                modifier = Modifier
                    .size(width = 150.dp, height = 100.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))
            FText(text = stream.title, fontSize = 14)
        }
    }
}