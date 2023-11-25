package org.sopt.sopkaton_team3.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkaton_team3.data.model.response.ResultResponse
import org.sopt.sopkaton_team3.data.repository.ResultRepository

class ResultViewModel(
    private val resultRepository: ResultRepository,
) : ViewModel() {
    private val _getResultData = MutableLiveData<ResultResponse.Data.FistUser>()
    val getResultData: LiveData<ResultResponse.Data.FistUser> get() = _getResultData

    private val _getResultItemData = MutableLiveData<List<ResultResponse.Data.Other>>()
    val getResultItemData: LiveData<List<ResultResponse.Data.Other>> get() = _getResultItemData

    private val _errorResult = MutableLiveData<String>()
    val errorResult: LiveData<String> get() = _errorResult

    suspend fun getResultData() {
        resultRepository.getResultData()
            .onSuccess { response ->
                _getResultData.value = response.data.fistUser
                _getResultItemData.value = response.data.other
            }
            .onFailure {
                _errorResult.value = it.message.toString()
            }
    }
}
