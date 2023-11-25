package org.sopt.sopkaton_team3.presentation.makeRoom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sopkaton_team3.data.ServicePool.makeRoomService
import org.sopt.sopkaton_team3.data.repository.MakeRoomRepository

class MakeRoomViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MakeRoomViewModel::class.java)) { //modelClass가 ExampleViewModel인지 확인
            val repository =
                MakeRoomRepository(makeRoomService)//dummyService를 인자로 받아서 Repository인스턴스 생성
            return MakeRoomViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}