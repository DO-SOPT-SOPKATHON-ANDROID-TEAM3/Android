package org.sopt.sopkaton_team3.presentation.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sopkaton_team3.data.ServicePool
import org.sopt.sopkaton_team3.data.repository.DummyRepository

class ExampleViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExampleViewModel::class.java)) { //modelClass가 ExampleViewModel인지 확인
            val repository =
                DummyRepository(ServicePool.exampleService)//dummyService를 인자로 받아서 Repository인스턴스 생성
            return ExampleViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}