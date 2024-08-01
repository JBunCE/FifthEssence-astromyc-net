package ui.model

import androidx.lifecycle.ViewModel
import core.retrofit.repository.PublicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ui.model.data.PublicationState

class ProfileViewModel (
    private val publicationRepository: PublicationRepository = PublicationRepository(),
) : ViewModel() {
    private val  _state = MutableStateFlow<PublicationState?>(PublicationState())
    val state: StateFlow<PublicationState?> = _state

    suspend fun getPublications(userId: String) {
        publicationRepository.getUserPublications(userId).data.let {
            _state.value = _state.value?.copy(publications = it)
        }
    }
}