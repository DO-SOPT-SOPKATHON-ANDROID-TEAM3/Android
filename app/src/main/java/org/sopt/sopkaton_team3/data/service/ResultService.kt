package org.sopt.sopkaton_team3.data.service

import org.sopt.sopkaton_team3.data.model.response.ResultResponse
import retrofit2.http.GET

interface ResultService {

    @GET("/result")
    suspend fun getResultData(): ResultResponse
}
