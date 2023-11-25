package org.sopt.sopkaton_team3.data.service

import org.sopt.sopkaton_team3.data.model.request.RequesetCreateRoom
import org.sopt.sopkaton_team3.data.model.response.ResponseCreateRoom
import retrofit2.http.Body
import retrofit2.http.POST

interface MakeRoomService{
    @POST("/room/create")
    suspend fun createRoom(@Body info: RequesetCreateRoom): ResponseCreateRoom
}