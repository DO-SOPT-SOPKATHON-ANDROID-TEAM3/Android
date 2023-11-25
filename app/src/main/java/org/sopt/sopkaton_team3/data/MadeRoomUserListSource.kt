package org.sopt.sopkaton_team3.data

import org.sopt.sopkaton_team3.data.model.response.ResponseData
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData
import org.sopt.sopkaton_team3.data.repository.MadeRoomRepository
import org.sopt.sopkaton_team3.data.service.MadeRoomService

class MadeRoomUserListSource: MadeRoomService {
    override suspend fun getUserList(): ResponseUserListData = MadeRoomUserList.data
}