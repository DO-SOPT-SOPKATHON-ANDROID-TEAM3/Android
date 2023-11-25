package org.sopt.sopkaton_team3.data.repository

import org.sopt.sopkaton_team3.data.service.ResultService

class ResultRepository(
    private val resultService: ResultService,
) {
    suspend fun getResultData() =
        runCatching {
            resultService.getResultData()
        }
}
