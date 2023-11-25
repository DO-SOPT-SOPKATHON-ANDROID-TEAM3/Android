package org.sopt.sopkaton_team3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sopkaton_team3.data.ServicePool
import org.sopt.sopkaton_team3.data.repository.ResultRepository

class ResultViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            val repository =
                ResultRepository(ServicePool.resultService)
            return ResultViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}
