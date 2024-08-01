package ui.screens

import FifthEssenceScreens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import core.retrofit.repository.UserRepository
import data.UserLocalDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ui.components.FButton
import ui.components.FPhoneNumber
import ui.components.FText
import ui.components.FTextField
import ui.model.RegisterScreenViewModel

@Composable
fun RegisterScreen(
    registerViewModel: RegisterScreenViewModel = viewModel(),
    navHostController: NavHostController
) {
    val register = registerViewModel.registerState.collectAsState()
    val context = LocalContext.current
    val userRepository = remember {
        UserLocalDataRepository(context)
    }

    register.value?.let {state ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                FText(text = "Register", fontSize = 38)
                Spacer(modifier = Modifier.height(2.dp))
                FText(text = "Welcome space traveler", fontSize = 14)

                Spacer(modifier = Modifier.height(40.dp))

                FText(text = "Username *", fontSize = 13)
                Spacer(modifier = Modifier.height(2.dp))

                FTextField(
                    placeholder = "Username",
                    onValueChange = registerViewModel::onUsernameChanged
                )

                Spacer(modifier = Modifier.height(40.dp))

                FText(text = "Phone number *", fontSize = 13)
                Spacer(modifier = Modifier.height(2.dp))
                FPhoneNumber(onValueChange = registerViewModel::onPhoneNumberChanged)

                Spacer(modifier = Modifier.height(40.dp))

                FText(text = "Email", fontSize = 13)
                Spacer(modifier = Modifier.height(2.dp))
                FTextField(
                    placeholder = "Email",
                    onValueChange = registerViewModel::onEmailChanged
                )

                Spacer(modifier = Modifier.height(40.dp))

                FText(text = "Password", fontSize = 13)
                Spacer(modifier = Modifier.height(2.dp))
                FTextField(
                    placeholder = "Password",
                    onValueChange = registerViewModel::onPasswordChanged
                )

                Spacer(modifier = Modifier.weight(1f))
                FButton(text = "Register", onClick = {
                    registerViewModel.createUser(state, userRepository)
                    navHostController.navigate(FifthEssenceScreens.PUBLICATIONS.name)
                })
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }

}