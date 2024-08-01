package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import data.UserLocalDataRepository
import ui.components.FText
import ui.components.Publication
import ui.model.ProfileViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val userRepository = remember {
        UserLocalDataRepository(context)
    }
    val user by userRepository.user.collectAsState(initial = null)
    val publications = profileViewModel.state.collectAsState()

    user?.let {
        LaunchedEffect(key1 = true) {
            profileViewModel.getPublications(user!!.id)
        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.size(30.dp))
        Icon(
            Icons.Rounded.AccountCircle,
            contentDescription = "Profile",
            Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        user?.let { Username(username = it.username) }
        Spacer(modifier = Modifier.size(10.dp))
        user?.let { Email(email = it.email) }

        Spacer(modifier = Modifier.size(20.dp))

        HorizontalDivider(
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.size(15.dp))

        publications.value?.publications.let {
            it?.forEach { publication ->
                Publication(publication = publication)
            }
        }

    }
}

@Composable
fun Username(username: String = "username") {
    Row {
        FText(text = username, fontSize = 20)
        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            Icons.Rounded.Create,
            contentDescription = "Profile",
            Modifier.size(20.dp)
        )
    }
}

@Composable
fun Email(email: String = "email") {
    Row {
        Icon(
            Icons.Rounded.Email,
            contentDescription = "Email",
            Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.size(5.dp))
        FText(text = email, fontSize = 14)
        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            Icons.Rounded.Create,
            contentDescription = "Email",
            Modifier.size(20.dp)
        )
    }
}