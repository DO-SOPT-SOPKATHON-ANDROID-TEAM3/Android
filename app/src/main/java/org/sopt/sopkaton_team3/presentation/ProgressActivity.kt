package org.sopt.sopkaton_team3.presentation

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.viewModels
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityProgressBinding
import org.sopt.sopkaton_team3.util.binding.BindingActivity

class ProgressActivity : BindingActivity<ActivityProgressBinding>(R.layout.activity_progress) {
    private val progressViewModel by viewModels<ProgressViewModel>()
    private var totalPeople = 7

    private val countDownTimer =
        object :
            CountDownTimer((((totalPeople - 4) * MILLISECONDS).toLong()), MILLISECONDS.toLong()) {
            override fun onTick(millisUntilFinished: Long) {
                val peopleRemaining = millisUntilFinished / MILLISECONDS

                getLeftPeople(totalPeople - peopleRemaining)
            }

            override fun onFinish() {
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewmodel = progressViewModel

        startTimer()
        initCircularProgressBar()
    }

    private fun initCircularProgressBar() {
        progressViewModel.setMaxPeople(totalPeople.toFloat())
        progressViewModel.leftPeople.observe(this) { time ->
            time?.let {
                binding.circularProgressBar.progress = it.toFloat()
            }
        }
    }

    private fun getLeftPeople(secondsRemaining: Long) {
        progressViewModel.updateLeftPeople(secondsRemaining)
    }

    private fun startTimer() {
        countDownTimer.start()
    }

    companion object {
        private const val MILLISECONDS = 1000
    }
}
