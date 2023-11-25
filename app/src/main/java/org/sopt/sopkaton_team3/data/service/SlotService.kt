package org.sopt.sopkaton_team3.data.service


import org.sopt.sopkaton_team3.data.model.response.ResponseGetSlotDto
import retrofit2.http.GET

interface SlotService {
    @GET("/slot")
    suspend fun getSlot(
    ): ResponseGetSlotDto
}