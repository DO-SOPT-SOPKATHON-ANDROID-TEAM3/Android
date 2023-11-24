package org.sopt.sopkaton_team3.data.repository

import org.sopt.sopkaton_team3.data.service.ExampleService

class DummyRepository(
    private val exampleService: ExampleService
) {
    suspend fun getDummy() =
        runCatching {
            exampleService.getDummy().data
        }
}