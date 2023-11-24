package org.sopt.sopkaton_team3.data.service

import org.sopt.sopkaton_team3.data.model.response.ResponseData

interface ExampleService {
    suspend fun getDummy(): ResponseData
}