package org.sopt.sopkaton_team3.data

import org.sopt.sopkaton_team3.data.model.response.ResponseData
import org.sopt.sopkaton_team3.data.service.ExampleService

class ExampleSource : ExampleService {
    override suspend fun getDummy(): ResponseData = DummyList.data
}