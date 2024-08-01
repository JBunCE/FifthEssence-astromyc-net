package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleCard() {
    Spacer(modifier = Modifier.height(10.dp))
    Column(
        Modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            ),
        verticalArrangement = Arrangement.Center,
    ) {
        Row (
            Modifier.fillMaxWidth().padding(20.dp),
        ) {

            Row(
                Modifier.width(160.dp),
            ) {
                Icon(
                    Icons.Rounded.DateRange,
                    contentDescription = "Schedule"
                )
                Spacer(modifier = Modifier.width(10.dp))
                FText(text = "Event name", fontSize = 15)
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FText(text = "10/7/2024", fontSize = 15)
                FText(text = "10:30", fontSize = 15)
            }
        }
    }
}