package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import core.model.response.StreamResponse

@Composable
fun StreamRow(
    streams: MutableList<StreamResponse>,
    navHostController: NavHostController
) {

    Row (
        Modifier.fillMaxSize().padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        if (streams.isNotEmpty()) {
            StreamCard(stream = streams.removeAt(0), navHostController = navHostController)
        }

        if (streams.isNotEmpty()) {
            StreamCard(stream = streams.removeAt(0), navHostController = navHostController)
        }
    }

    if (streams.isNotEmpty()) {
        StreamRow(streams = streams, navHostController = navHostController)
    }
}