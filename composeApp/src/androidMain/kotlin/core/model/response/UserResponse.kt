package core.model.response

data class UserResponse(
    val id: String,
    val username: String,
    val phoneNumber: String,
    val email: String,
    val createdAt: String,
    val role: RoleResponse
)
