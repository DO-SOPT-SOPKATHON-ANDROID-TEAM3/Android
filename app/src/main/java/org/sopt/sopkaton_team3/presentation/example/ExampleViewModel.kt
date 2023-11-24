package org.sopt.sopkaton_team3.presentation.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkaton_team3.data.model.response.ResponseData
import org.sopt.sopkaton_team3.data.repository.DummyRepository
import org.sopt.sopkaton_team3.util.view.UiState

class ExampleViewModel(
    private val dummyRepository: DummyRepository
) : ViewModel() {
    private val _getDummyResult = MutableLiveData<ResponseData.DummyData>()
    val getDummyResult: LiveData<ResponseData.DummyData> get() = _getDummyResult

    private val _errorResult = MutableLiveData<String>()
    val errorResult: LiveData<String> get() = _errorResult

    private val _getDummyState = MutableLiveData<UiState<ResponseData.DummyData>>(UiState.Empty)
    val getDummyState: LiveData<UiState<ResponseData.DummyData>> get() = _getDummyState

    suspend fun getData1() {
        dummyRepository.getDummy()
            .onSuccess { response ->
                _getDummyResult.value = response
            }
            .onFailure {
                _errorResult.value = it.message.toString()
            }
    }

    suspend fun getData() {
        dummyRepository.getDummy()
            .onSuccess { response ->
                _getDummyState.value = UiState.Success(response)
            }
            .onFailure {
                _getDummyState.value = UiState.Failure(it.message.toString())
            }
    }
}