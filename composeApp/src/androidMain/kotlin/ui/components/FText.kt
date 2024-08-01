package ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun FText(
    text: String,
    fontSize: Int,
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onPrimary,
        fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
        fontSize = fontSize.sp
    )
}

@Composable
fun FText(
    text: String,
    fontSize: Int,
    color: androidx.compose.ui.graphics.Color
) {
    Text(
        text = text,
        color = color,
        fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
        fontSize = fontSize.sp
    )
}