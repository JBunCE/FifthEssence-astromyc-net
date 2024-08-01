package core.retrofit.repository

import core.model.BaseResponse
import core.model.request.UserRequest
import core.model.response.UserResponse
import core.retrofit.RetrofitServiceFactory

class UserRepository {
    private val service = RetrofitServiceFactory.userService

    suspend fun createUser(userRequest: UserRequest): BaseResponse<UserResponse> {
        return service.createUser(userRequest);
    }
}