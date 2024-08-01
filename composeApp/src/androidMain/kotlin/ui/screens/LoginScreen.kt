package ui.screens

import FifthEssenceScreens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import data.UserLocalDataRepository
import ui.components.FButton
import ui.components.FPhoneNumber
import ui.components.FText
import ui.components.FTextField

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    val userRepository = remember {
        UserLocalDataRepository(context)
    }

    val user by userRepository.user.collectAsState(initial = null)

    if (user != null) {
        navController.navigate(FifthEssenceScreens.PUBLICATIONS.name)
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            FText(text = "Login", fontSize = 38)
            Spacer(modifier = Modifier.height(2.dp))
            FText(text = "Login with your phone number", fontSize = 14)
            Spacer(modifier = Modifier.height(50.dp))
            FPhoneNumber()
            Spacer(modifier = Modifier.height(50.dp))
            FTextField(placeholder = "Password")
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(200.dp))
            FButton(text = "Next", onClick = {
                navController.navigate(FifthEssenceScreens.PUBLICATIONS.name)
            })
            Spacer(modifier = Modifier.height(25.dp))
            FText(text = "Don't have an account?", fontSize = 13)
            Spacer(modifier = Modifier.height(5.dp))
            FButton(text = "Register", onClick = {
                navController.navigate(FifthEssenceScreens.REGISTER.name)
            })
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}