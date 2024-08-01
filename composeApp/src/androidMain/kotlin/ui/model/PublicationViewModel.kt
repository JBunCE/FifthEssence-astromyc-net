package ui.model

import androidx.lifecycle.ViewModel
import core.retrofit.repository.PublicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import ui.model.data.PublicationState

class PublicationViewModel(
    private val publicationRepository: PublicationRepository = PublicationRepository(),
) : ViewModel() {
    private val _state = MutableStateFlow<PublicationState>(PublicationState())
    val state = _state

    suspend fun getPublications() {
        publicationRepository.getPublications().data.let {
            _state.value = _state.value.copy(publications = it)
        }
    }
}