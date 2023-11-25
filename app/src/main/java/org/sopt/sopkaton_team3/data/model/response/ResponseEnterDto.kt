package org.sopt.sopkaton_team3.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseEnterDto (
    @SerialName("status")
    val status: Int?,
    @SerialName("success")
    val success: Boolean?,
    @SerialName("message")
    val message: String?
)
