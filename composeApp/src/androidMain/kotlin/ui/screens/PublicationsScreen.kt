package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ui.components.FText
import ui.components.Publication
import ui.model.PublicationViewModel

@Composable
fun PublicationsScreen(
    publicationViewModel: PublicationViewModel = viewModel()
) {
    val publications = publicationViewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        publicationViewModel.getPublications()
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {
        val scrollState = rememberScrollState()

        Spacer(modifier = Modifier.height(15.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            FText(text = "Publication", fontSize = 25)
        }
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.primary)

        Column (
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(scrollState)
        ) {
            publications.value.publications.let {
                it.forEach { publication ->
                    Publication(publication = publication)
                }
            }
        }
    }
}