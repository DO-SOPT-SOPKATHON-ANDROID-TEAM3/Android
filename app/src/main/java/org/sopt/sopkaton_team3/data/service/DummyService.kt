package org.sopt.sopkaton_team3.data.service

import org.sopt.sopkaton_team3.data.model.request.RequestData
import org.sopt.sopkaton_team3.data.model.response.ResponseData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {
    @POST("api")
    suspend fun postData(
        @Body requestData: RequestData
    ): ResponseData

    @GET("api")
    suspend fun getData(
        @Query("page") page: Int
    ): ResponseData
}