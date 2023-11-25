package org.sopt.sopkaton_team3.presentation.progress

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.viewModels
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityProgressBinding
import org.sopt.sopkaton_team3.presentation.result.ResultActivity
import org.sopt.sopkaton_team3.util.binding.BindingActivity

class ProgressActivity : BindingActivity<ActivityProgressBinding>(R.layout.activity_progress) {
    private val progressViewModel by viewModels<ProgressViewModel>()
    private var totalPeople = 6
    private var name: String? = null

    private val countDownTimer =
        object :
            CountDownTimer(((totalPeople * MILLISECONDS).toLong()), MILLISECONDS.toLong()) {
            override fun onTick(millisUntilFinished: Long) {
                val peopleRemaining = millisUntilFinished / MILLISECONDS

                getLeftPeople(totalPeople - peopleRemaining)
            }

            override fun onFinish() {
                val intent = Intent(this@ProgressActivity, ResultActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewmodel = progressViewModel
        name = intent.getStringExtra("name")
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
