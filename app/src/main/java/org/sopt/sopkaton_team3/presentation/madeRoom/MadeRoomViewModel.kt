package org.sopt.sopkaton_team3.presentation.madeRoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData
import org.sopt.sopkaton_team3.data.repository.MadeRoomRepository

class MadeRoomViewModel(
    private val madeRoomRepository: MadeRoomRepository
) : ViewModel() {
    private val _userList = MutableLiveData<List<ResponseUserListData.UserInfo>>()
    val userList: LiveData<List<ResponseUserListData.UserInfo>> get() = _userList

    private val _userListSuccess = MutableLiveData<Boolean>()
    val userListSuccess: LiveData<Boolean> get() = _userListSuccess


    suspend fun loadUserList(name: String) {
        madeRoomRepository.getUserList()
            .onSuccess {
                val user = ResponseUserListData.UserInfo(
                    image = R.drawable.img_graph_profile,
                    name = name,
                    role = "방장"
                )
                val list = it.userList.toMutableList()
                list.add(0, user)
                _userList.value = list
                _userListSuccess.value = true
            }
            .onFailure {
                _userListSuccess.value = false
            }
    }
}