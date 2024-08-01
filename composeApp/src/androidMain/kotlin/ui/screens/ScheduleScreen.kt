package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.FText
import ui.components.ScheduleCard

@Composable
fun ScheduleScreen() {

    val scroll = rememberScrollState()

    Column (
        Modifier.fillMaxSize().padding(5.dp)
            .verticalScroll(scroll)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            FText(text = "Schedule", fontSize = 25)
        }
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.primary)

        ScheduleCard()
        ScheduleCard()
        ScheduleCard()
        ScheduleCard()
        ScheduleCard()
    }
}