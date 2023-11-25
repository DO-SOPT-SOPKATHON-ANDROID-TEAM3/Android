package org.sopt.sopkaton_team3.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseCreateRoom(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: CodeData,
) {
    @Serializable
    data class CodeData(
        val id: Int,
        val code: String
    )
}
