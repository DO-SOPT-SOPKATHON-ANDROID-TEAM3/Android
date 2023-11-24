package org.sopt.sopkaton_team3.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestData(
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
)