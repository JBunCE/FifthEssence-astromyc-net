package core.model.request

data class PublicationRequest(
    val body: String,
    val isPrivate: Boolean,
    val isEvent: Boolean,
    val authorId: String,
    val eventId: Int,
)