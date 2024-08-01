package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InteractionBar() {
    Row (
        Modifier.fillMaxWidth()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(horizontal = 0.dp) ,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Rounded.Favorite,
                contentDescription = "Like",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(5.dp))
            FText(text = "Like", fontSize = 12)
        }

        Spacer(modifier = Modifier.width(15.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(horizontal = 0.dp) ,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Share"
            )
            Spacer(modifier = Modifier.width(5.dp))
            FText(text = "Share", fontSize = 12)
        }

        Spacer(modifier = Modifier.width(15.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(horizontal = 0.dp) ,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Rounded.Create,
                contentDescription = "Comment"
            )
            Spacer(modifier = Modifier.width(5.dp))
            FText(text = "Comment", fontSize = 12)
        }
    }
}