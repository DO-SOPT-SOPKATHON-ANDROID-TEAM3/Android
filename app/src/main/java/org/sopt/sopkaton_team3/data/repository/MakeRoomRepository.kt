package org.sopt.sopkaton_team3.data.repository

import org.sopt.sopkaton_team3.data.model.request.RequesetCreateRoom
import org.sopt.sopkaton_team3.data.model.response.ResponseCreateRoom
import org.sopt.sopkaton_team3.data.service.MakeRoomService

class MakeRoomRepository(
    private val makeRoomService: MakeRoomService
) {
    suspend fun createRoom(info: RequesetCreateRoom) =
        runCatching {
            makeRoomService.createRoom(info)
        }
}