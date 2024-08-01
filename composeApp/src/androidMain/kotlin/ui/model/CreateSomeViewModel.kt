package ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.retrofit.repository.PublicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ui.model.data.CreateSomeState

class CreateSomeViewModel(
    private val publicationRepository: PublicationRepository = PublicationRepository(),
) : ViewModel() {
    private val _state = MutableStateFlow<CreateSomeState>(CreateSomeState())
    val state: StateFlow<CreateSomeState> = _state

    fun setAuthorId(authorId: String) {
        _state.value = _state.value.copy(authorId = authorId)
    }

    fun onBodyChanged(body: String) {
        _state.value = _state.value.copy(body = body)
    }

    fun createPublication() {
        viewModelScope.launch {
            publicationRepository.createPublication(_state.value.toPublicationRequest())
        }
    }
}