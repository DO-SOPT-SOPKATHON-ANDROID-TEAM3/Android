package org.sopt.sopkaton_team3.data.repository

import org.sopt.sopkaton_team3.data.model.request.RequestEnterDto
import org.sopt.sopkaton_team3.data.service.EnterService

class EnterRoomRepository(
    private val enterService: EnterService
) {
    suspend fun getEnter(user: RequestEnterDto) =
        runCatching {
            enterService.checkEnterAvailableFromServer(user)
        }
}