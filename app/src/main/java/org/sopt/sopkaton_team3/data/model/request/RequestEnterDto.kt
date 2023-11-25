package org.sopt.sopkaton_team3.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestEnterDto (
    @SerialName("code")
    val code: String?,
    @SerialName("name")
    val name: String?
    )