package core.model.response

import java.util.Objects

data class StreamResponse(
    val id: Int,
    val title: String,
    val description: String,
    val WRTCUrl: String,
    val startDate: String,
    val endDate: String,
    val startTime: String,
    val endTime: String,
    val likeCount: Int,
    val authorId: String,
    val comments: List<CommentResponse>
)
