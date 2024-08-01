package core.retrofit.services

import core.model.BaseResponse
import core.model.request.PublicationRequest
import core.model.response.PublicationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IPublicationService {
    @GET("publication")
    suspend fun getPublications(): BaseResponse<List<PublicationResponse>>

    @GET("publication/from-user")
    suspend fun getUserPublications(@Query("userId") authorId: String): BaseResponse<List<PublicationResponse>>

    @POST("publication")
    suspend fun createPublication(@Body request: PublicationRequest): BaseResponse<PublicationResponse>
}