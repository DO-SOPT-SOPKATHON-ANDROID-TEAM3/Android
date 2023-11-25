package org.sopt.sopkaton_team3.presentation.slot

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivitySlotBinding
import org.sopt.sopkaton_team3.presentation.progress.ProgressActivity

class SlotActivity : AppCompatActivity() {
    lateinit var binding: ActivitySlotBinding
    private val viewModel: SlotViewModel by viewModels { SlotViewModelFactory() }
    private lateinit var slotAdapter1: SlotAdapter
    private lateinit var slotAdapter2: SlotAdapter
    private lateinit var slotAdapter3: SlotAdapter
    var currentPage = 0
    var currentCheck = 1
    private var job1: Job? = null
    private var job2: Job? = null
    private var job3: Job? = null
    private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlotBinding.inflate(layoutInflater)
        name = intent.getStringExtra("name")
        setContentView(binding.root)
        lifecycleScope.launch { viewModel.getSlot() }
        slotAdapter1 = SlotAdapter()
        slotAdapter2 = SlotAdapter()
        slotAdapter3 = SlotAdapter()
        binding.vp1.adapter = slotAdapter1
        binding.vp2.adapter = slotAdapter2
        binding.vp3.adapter = slotAdapter3
        slotAdapter1.submitList(viewModel.list1)
        slotAdapter2.submitList(viewModel.list2)
        slotAdapter3.submitList(viewModel.list3)

        binding.tvSlotWhopick.text = "\"$name\""
        initJob()

        var isAnimating = false

        binding.mlSlotDown.setTransitionListener(
            object : MotionLayout.TransitionListener {
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
            if (!isAnimating) {
                when (binding.mlSlotDown.currentState) {
                    R.id.start -> {
                        isAnimating = true
                        binding.mlSlotDown.transitionToState(R.id.end)
                        if (currentCheck == 1) {
                            job1?.cancel()
                            slotAdapter1.submitList(viewModel.listTwo.value)
                            currentCheck++
                        } else if (currentCheck == 2) {
                            job2?.cancel()
                            slotAdapter2.submitList(viewModel.listThree.value)
                            currentCheck++
                        } else if (currentCheck == 3) {
                            job3?.cancel()
                            slotAdapter3.submitList(viewModel.listOne.value)
                            binding.btnStart.isVisible = true
                            binding.btnStart.setOnClickListener {
                                val intent = Intent(this, ProgressActivity::class.java)
                                intent.putExtra("name", name)
                                startActivity(intent)
                            }
                            currentCheck++
                        }
                    }

                    R.id.move3 -> {
                        binding.mlSlotDown.transitionToState(R.id.start)
                    }
                }
            }
        }

        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initJob() {
        job1 = lifecycleScope.launch {
            while (true) {
                delay(100)
                setPage1()
            }
        }
        job2 = lifecycleScope.launch {
            while (true) {
                delay(100)
                setPage2()
            }
        }
        job3 = lifecycleScope.launch {
            while (true) {
                delay(100)
                setPage3()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job1 = null
        job2 = null
        job3 = null
    }

    //페이지 변경하기
    fun setPage1() {
        if (currentPage == 6)
            currentPage = 0
        binding.vp1.setCurrentItem(currentPage, true)
        currentPage += 1
    }

    fun setPage2() {
        if (currentPage == 6)
            currentPage = 0
        binding.vp2.setCurrentItem(currentPage, true)
        currentPage += 1
    }

    fun setPage3() {
        if (currentPage == 6)
            currentPage = 0
        binding.vp3.setCurrentItem(currentPage, true)
        currentPage += 1
    }
}