package core.retrofit.services

import core.model.BaseResponse
import core.model.request.UserRequest
import core.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IUserService {
    @GET
    suspend fun getUser()

    @POST("user")
    suspend fun createUser(@Body userRequest: UserRequest): BaseResponse<UserResponse>
}