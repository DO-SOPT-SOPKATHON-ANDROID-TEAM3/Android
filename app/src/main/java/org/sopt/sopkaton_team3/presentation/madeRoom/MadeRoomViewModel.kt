package org.sopt.sopkaton_team3.presentation.madeRoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData
import org.sopt.sopkaton_team3.data.repository.MadeRoomRepository

class MadeRoomViewModel(
    private val madeRoomRepository: MadeRoomRepository
) : ViewModel(){
    private val _userList = MutableLiveData<ResponseUserListData>()
    val userList: LiveData<ResponseUserListData> get() = _userList

    private val _userListSuccess = MutableLiveData<Boolean>()
    val userListSuccess: LiveData<Boolean> get() = _userListSuccess


    suspend fun loadUserList(){
        madeRoomRepository.getUserList()
            .onSuccess {
                _userList.value = it
                _userListSuccess.value = true
            }
            .onFailure {
                _userListSuccess.value = false
            }
    }
}