package core.model.response

import org.threeten.bp.LocalDate

data class CommentResponse(
    val id: Long,
    val authorId: String,
    val body: String,
    val createdAt: LocalDate,
    val deletedAt: LocalDate?,
)