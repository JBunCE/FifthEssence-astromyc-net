package ui.model.data

import core.model.request.UserRequest
import core.model.response.UserResponse

data class RegisterScreenState(
    val username: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val password: String = "",
    val roleId: Int = 1,
    val userResponse: UserResponse? = null,
) {
    fun toUserRequest() = UserRequest(
        username = username,
        phoneNumber = phoneNumber,
        email = email,
        password = password,
        roleId = roleId,
    )
};
