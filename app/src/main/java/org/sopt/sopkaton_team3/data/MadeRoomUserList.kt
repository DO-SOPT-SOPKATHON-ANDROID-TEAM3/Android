package org.sopt.sopkaton_team3.data

import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData

object MadeRoomUserList {
    val data: ResponseUserListData = ResponseUserListData(
        listOf(
            ResponseUserListData.UserInfo(
                image = R.drawable.img_watermelon_profile,
                name = "양정윤",
                role = "방장",
            ),
            ResponseUserListData.UserInfo(
                image = R.drawable.img_graph_profile,
                name = "손흥민",
                role = "조원",
            ),
            ResponseUserListData.UserInfo(
                image = R.drawable.img_diamond_profile,
                name = "서호영",
                role = "조원",
            ),
            ResponseUserListData.UserInfo(
                image = R.drawable.img_orange_profile,
                name = "강채연",
                role = "조원",
            ),
            ResponseUserListData.UserInfo(
                image = R.drawable.img_seven_profile,
                name = "윤정원",
                role = "조원",
            ),
        ),
    )
}
