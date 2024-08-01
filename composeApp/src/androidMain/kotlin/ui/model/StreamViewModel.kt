package ui.model

import androidx.lifecycle.ViewModel
import core.retrofit.repository.StreamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import ui.model.data.StreamsState

class StreamViewModel(
    private val streamRepository: StreamRepository = StreamRepository(),
) : ViewModel() {
    private val _state = MutableStateFlow<StreamsState?>(StreamsState())
    val state = _state

    suspend fun getStreams() {
        streamRepository.getStream().data.let {
            _state.value = _state.value?.copy(streams = it)
        }
    }
}