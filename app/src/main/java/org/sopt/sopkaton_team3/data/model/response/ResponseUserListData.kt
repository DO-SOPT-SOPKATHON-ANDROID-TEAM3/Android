package org.sopt.sopkaton_team3.data.model.response

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserListData(
    val userList: List<UserInfo>
) {
    @Serializable
    data class UserInfo(
        @DrawableRes val image: Int,
        val name: String,
        val role: String,
    )
}