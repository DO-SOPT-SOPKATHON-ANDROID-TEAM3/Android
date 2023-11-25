package org.sopt.sopkaton_team3.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivitySlotBinding

class SlotActivity : AppCompatActivity() {
    lateinit var binding: ActivitySlotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var isAnimating = false

        binding.mlSlotDown.setTransitionListener(
            object : MotionLayout.TransitionListener{
                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int
                ) {
                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {
                }

                override fun onTransitionCompleted(
                    motionLayout: MotionLayout?,
                    currentId: Int
                ) {
                    isAnimating = false
                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float
                ) {
                }

            }
        )

        binding.ivSlotDown.setOnClickListener {
            if(!isAnimating) {
                when(binding.mlSlotDown.currentState) {
                    R.id.start -> {
                        isAnimating = true
                        binding.mlSlotDown.transitionToState(R.id.end)

                    }
                    R.id.move3 -> {
                        binding.mlSlotDown.transitionToState(R.id.start)
                    }
                }
            }
        }
    }
}