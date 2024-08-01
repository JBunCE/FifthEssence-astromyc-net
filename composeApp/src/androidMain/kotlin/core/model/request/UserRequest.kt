package core.model.request

data class UserRequest(
    val username: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val roleId: Int,
)
