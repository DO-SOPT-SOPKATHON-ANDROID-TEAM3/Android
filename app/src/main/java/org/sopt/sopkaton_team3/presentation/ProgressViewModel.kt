package org.sopt.sopkaton_team3.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel() : ViewModel() {

    private val _leftPeople = MutableLiveData<Long?>()
    val leftPeople: LiveData<Long?> get() = _leftPeople

    private val _maxPeople = MutableLiveData<Float>()
    val maxPeople: LiveData<Float> get() = _maxPeople

    fun updateLeftPeople(leftPeople: Long?) {
        _leftPeople.value = leftPeople
    }

    fun setMaxPeople(maxPeople: Float) {
        _maxPeople.value = maxPeople
    }
}
