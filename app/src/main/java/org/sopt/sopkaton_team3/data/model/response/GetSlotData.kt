package org.sopt.sopkaton_team3.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetSlotDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: GetSlotData
){
    @Serializable
    data class GetSlotData(
        @SerialName("id")
        val id: Int,
        @SerialName("who")
        val who: String,
        @SerialName("where")
        val where: String,
        @SerialName("what")
        val what: String
    )
}


