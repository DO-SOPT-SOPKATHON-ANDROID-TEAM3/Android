package org.sopt.sopkaton_team3.data.repository

import org.sopt.sopkaton_team3.data.service.SlotService

class SlotRepository(
    private val service: SlotService
) {
    suspend fun getSlot() = runCatching {
        service.getSlot().data
    }
}