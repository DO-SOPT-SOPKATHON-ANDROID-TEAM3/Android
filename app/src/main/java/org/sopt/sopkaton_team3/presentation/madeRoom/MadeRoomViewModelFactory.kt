package org.sopt.sopkaton_team3.presentation.madeRoom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sopkaton_team3.data.ServicePool
import org.sopt.sopkaton_team3.data.repository.MadeRoomRepository

class MadeRoomViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MadeRoomViewModel::class.java)) { //modelClass가 ExampleViewModel인지 확인
            val repository =
                MadeRoomRepository(ServicePool.madeRoomService)//dummyService를 인자로 받아서 Repository인스턴스 생성
            return MadeRoomViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}