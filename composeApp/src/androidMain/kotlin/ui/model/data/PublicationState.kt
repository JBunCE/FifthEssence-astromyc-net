package ui.model.data

import core.model.response.PublicationResponse

data class PublicationState(
    val publications: List<PublicationResponse> = emptyList(),
)