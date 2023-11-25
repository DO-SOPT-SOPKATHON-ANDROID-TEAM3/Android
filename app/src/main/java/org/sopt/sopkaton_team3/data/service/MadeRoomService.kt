package org.sopt.sopkaton_team3.data.service

import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData

interface MadeRoomService {
    suspend fun getUserList(): ResponseUserListData
}