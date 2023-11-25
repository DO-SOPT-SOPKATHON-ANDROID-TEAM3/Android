package org.sopt.sopkaton_team3.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    @SerialName("data")
    val `data`: Data,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
) {
    @Serializable
    data class Data(
        @SerialName("fistUser")
        val fistUser: FistUser,
        @SerialName("Other")
        val other: List<Other>,
    ) {
        @Serializable
        data class FistUser(
            @SerialName("name")
            val name: String,
            @SerialName("what")
            val what: String,
            @SerialName("where")
            val `where`: String,
            @SerialName("who")
            val who: String,
        )

        @Serializable
        data class Other(
            @SerialName("name")
            val name: String,
            @SerialName("todo")
            val todo: String,
        )
    }
}
