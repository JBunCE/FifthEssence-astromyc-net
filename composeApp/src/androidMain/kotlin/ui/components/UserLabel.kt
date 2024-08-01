package ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserLabel(
    username: String = "USERNAME"
) {
    Row (
        Modifier.fillMaxWidth()
    ) {
        Icon(
            Icons.Rounded.AccountCircle,
            contentDescription = "Profile",
            Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .height(25.dp)
                .fillMaxWidth()
        ) {
            FText(text = username, fontSize = 12)
        }
    }

}