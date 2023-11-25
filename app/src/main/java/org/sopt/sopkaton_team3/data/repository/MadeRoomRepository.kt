package org.sopt.sopkaton_team3.data.repository

import org.sopt.sopkaton_team3.data.service.MadeRoomService

class MadeRoomRepository(
    private val madeRoomService: MadeRoomService
) {
    suspend fun getUserList() =
        runCatching {
            madeRoomService.getUserList()
        }
}