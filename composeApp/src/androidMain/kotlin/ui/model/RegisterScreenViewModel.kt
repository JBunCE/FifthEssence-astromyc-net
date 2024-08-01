package ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.retrofit.repository.UserRepository
import data.UserLocalDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ui.model.data.RegisterScreenState

class RegisterScreenViewModel(
    private val userRepository: UserRepository = UserRepository(),
) : ViewModel() {
    private val _registerState = MutableStateFlow<RegisterScreenState?>(RegisterScreenState())
    val registerState: StateFlow<RegisterScreenState?> = _registerState

    fun onUsernameChanged(username: String) {
        _registerState.value = _registerState.value?.copy(username = username)
    }

    fun onPhoneNumberChanged(phoneNumber: String) {
        _registerState.value = _registerState.value?.copy(phoneNumber = phoneNumber)
    }

    fun onEmailChanged(email: String) {
        _registerState.value = _registerState.value?.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _registerState.value = _registerState.value?.copy(password = password)
    }

    fun createUser(state: RegisterScreenState, userDataRepository: UserLocalDataRepository) {
        viewModelScope.launch {
            val user = userRepository.createUser(state.toUserRequest()).data
            userDataRepository.saveUser(user)
        }
    }
}