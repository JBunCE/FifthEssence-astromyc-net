package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FPhoneNumber(
    onValueChange: (String) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        DropdownMenu(/* TODO: Implement country code dropdown */)
        Spacer(modifier = Modifier.width(8.dp))
        FTextField(
            Extra = {
                Icon(
                    Icons.Rounded.Phone,
                    contentDescription = "Phone number",
                    tint = Color.White
                )
            },
            onValueChange = onValueChange,
            placeholder = "Phone number"
        )
    }
}

@Composable
fun DropdownMenu() {
    // Placeholder for the dropdown menu for selecting country code
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
            .height(56.dp)
    ) {
        Text(
            text = "+52",
            color = Color.White,
            modifier = Modifier.background(Color.Transparent)
        )
        Icon(
            Icons.Rounded.ArrowDropDown,
            contentDescription = "Phone number",
        )
    }
}