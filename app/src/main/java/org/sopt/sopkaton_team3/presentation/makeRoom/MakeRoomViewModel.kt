package org.sopt.sopkaton_team3.presentation.makeRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sopkaton_team3.data.model.request.RequesetCreateRoom
import org.sopt.sopkaton_team3.data.repository.MakeRoomRepository

class MakeRoomViewModel(
    private val makeRoomRepository: MakeRoomRepository
) : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _userNameSuccess = MutableLiveData<Boolean>()
    val userNameSuccess: LiveData<Boolean> get() = _userNameSuccess


    suspend fun createRoomBtn(name: String) {
        makeRoomRepository.createRoom(RequesetCreateRoom(name))
            .onSuccess {
                Log.e("TAG", "onCreate: sucess")
                _userNameSuccess.value = true
            }
            .onFailure {
                Log.e("TAG", "onCreate: fail${it}")
                _userNameSuccess.value = false
            }
    }
}