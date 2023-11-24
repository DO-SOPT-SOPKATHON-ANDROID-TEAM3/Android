package org.sopt.sopkaton_team3.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val status: Int,
    val message: String,
    val data: DummyData,
) {
    @Serializable
    data class DummyData(
        val id: Int,
        val name: String,
        val email: String,
    )
}
