package ui.screens

import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.asStateFlow
import ui.components.FText
import ui.components.StreamRow
import ui.model.StreamViewModel

@Composable
fun StreamScreen(
    streamViewModel: StreamViewModel = viewModel(),
    navHostController: NavHostController
) {
    val streams = streamViewModel.state.collectAsState()
    val scroll = rememberScrollState()

    LaunchedEffect(key1 = true) {
        streamViewModel.getStreams()
    }

    Column (
        Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .padding(5.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            FText(text = "Streams", fontSize = 25)
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
        streams.value?.streams.let {
            it?.let {
                StreamRow(streams = it.toMutableList(), navHostController = navHostController)
            }
        }
    }
}