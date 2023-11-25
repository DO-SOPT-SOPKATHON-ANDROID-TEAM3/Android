package org.sopt.sopkaton_team3.presentation.enterRoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.data.model.request.RequestEnterDto
import org.sopt.sopkaton_team3.data.model.response.ResponseEnterDto
import org.sopt.sopkaton_team3.data.repository.EnterRoomRepository

class EnterRoomViewModel(private val repository: EnterRoomRepository) : ViewModel() {
    private val _requestResult: MutableLiveData<ResponseEnterDto> = MutableLiveData()
    val requestResult: LiveData<ResponseEnterDto> get() = _requestResult

    private val _requestSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val requestSuccess: LiveData<Boolean> get() = _requestSuccess

    fun enter(code: String, name: String) {
        viewModelScope.launch {
            repository.getEnter(
                RequestEnterDto(
                    code,
                    name
                )
            )
                .onSuccess {
                    _requestResult.value = it
                    _requestSuccess.value = true
                }.onFailure {
                    _requestSuccess.value = false
                }
        }
    }
}