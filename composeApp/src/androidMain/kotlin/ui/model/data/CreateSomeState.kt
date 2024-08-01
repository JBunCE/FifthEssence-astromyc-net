package ui.model.data

import core.model.request.PublicationRequest

data class CreateSomeState(
    val body: String = "",
    val isPrivate: Boolean = false,
    val isEvent: Boolean = false,
    val authorId: String = "",
    val eventId: Int = 0,
) {
    fun toPublicationRequest() = PublicationRequest(
        body = body,
        isPrivate = isPrivate,
        isEvent = isEvent,
        authorId = authorId,
        eventId = eventId,
    )
}