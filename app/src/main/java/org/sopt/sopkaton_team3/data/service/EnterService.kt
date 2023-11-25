package org.sopt.sopkaton_team3.data.service

import org.sopt.sopkaton_team3.data.model.request.RequestEnterDto
import org.sopt.sopkaton_team3.data.model.response.ResponseEnterDto
import retrofit2.http.Body
import retrofit2.http.POST

interface EnterService {
    @POST("/room/enter")
    suspend fun checkEnterAvailableFromServer(
        @Body request: RequestEnterDto,
    ): ResponseEnterDto
}