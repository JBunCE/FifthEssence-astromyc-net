package core.retrofit.services

import core.model.BaseResponse
import core.model.response.StreamResponse
import retrofit2.http.GET

interface IStreamService {

    @GET("stream")
    suspend fun getStream(): BaseResponse<List<StreamResponse>>

}