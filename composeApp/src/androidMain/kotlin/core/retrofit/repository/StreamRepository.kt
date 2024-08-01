package core.retrofit.repository

import core.model.BaseResponse
import core.model.response.StreamResponse
import core.retrofit.RetrofitServiceFactory

class StreamRepository {
    private val service = RetrofitServiceFactory.streamService

    suspend fun getStream(): BaseResponse<List<StreamResponse>> {
        return service.getStream();
    }
}