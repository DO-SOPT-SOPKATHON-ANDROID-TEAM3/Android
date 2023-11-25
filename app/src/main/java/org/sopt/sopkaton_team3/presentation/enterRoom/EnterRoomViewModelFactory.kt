package org.sopt.sopkaton_team3.presentation.enterRoom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sopkaton_team3.data.ServicePool
import org.sopt.sopkaton_team3.data.repository.EnterRoomRepository

class EnterRoomViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EnterRoomViewModel::class.java)) {
            val repository =
                EnterRoomRepository(ServicePool.enterRoomService)
            return EnterRoomViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}