package core.model

data class BaseResponse<T>(
    val data: T,
    val message: String,
    val success: Boolean,
    val httpStatus: String,
    val httpCode: Int,
);