package core.bunstream

data class StreamData (
    val is_streamer: Int,
    val stream_id: Int,
)

data class StreamRequest(
    val type: String,
    val data: StreamData
) {
    fun toJson(): String {
        return "{\"type\": \"$type\", \"data\": {\"is_streamer\": ${data.is_streamer}, \"stream_id\": ${data.stream_id}}}"
    }
}
