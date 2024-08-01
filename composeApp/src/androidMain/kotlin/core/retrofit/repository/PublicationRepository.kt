package core.retrofit.repository

import core.model.BaseResponse
import core.model.request.PublicationRequest
import core.model.response.PublicationResponse
import core.retrofit.RetrofitServiceFactory

class PublicationRepository {
    private val service = RetrofitServiceFactory.publicationService

    suspend fun getPublications(): BaseResponse<List<PublicationResponse>> {
        return service.getPublications()
    }

    suspend fun getUserPublications(authorId: String): BaseResponse<List<PublicationResponse>> {
        return service.getUserPublications(authorId)
    }

    suspend fun createPublication(request: PublicationRequest): BaseResponse<PublicationResponse> {
        return service.createPublication(request)
    }
}