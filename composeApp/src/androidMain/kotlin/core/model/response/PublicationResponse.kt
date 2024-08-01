package core.model.response

data class PublicationResponse(
    val id: Int,
    val authorId: String,
    val authorName: String,
    val eventId: Int?,
    val body: String,
    val likes: Int,
    val isPrivate: Boolean,
    val isEvent: Boolean,
    val createdAt: String,
    val deletedAt: String?,
)