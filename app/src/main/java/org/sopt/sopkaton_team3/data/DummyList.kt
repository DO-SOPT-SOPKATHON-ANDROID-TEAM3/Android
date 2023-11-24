package org.sopt.sopkaton_team3.data

import org.sopt.sopkaton_team3.data.model.response.ResponseData

object DummyList {
    val data = ResponseData(
        200, "메시지", ResponseData.DummyData(
            1, "우상욱", "우상욱@네이버"
        )
    )
}