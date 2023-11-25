package org.sopt.sopkaton_team3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sopkaton_team3.data.ServicePool
import org.sopt.sopkaton_team3.data.repository.SlotRepository

class SlotViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SlotViewModel::class.java)) { //modelClass가 ExampleViewModel인지 확인
            val repository =
                SlotRepository(ServicePool.slotService)//dummyService를 인자로 받아서 Repository인스턴스 생성
            return SlotViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}