package org.sopt.sopkaton_team3.presentation.result

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityResultBinding
import org.sopt.sopkaton_team3.presentation.initRoom.InitRoomActivity
import org.sopt.sopkaton_team3.util.binding.BindingActivity

class ResultActivity : BindingActivity<ActivityResultBinding>(R.layout.activity_result) {
    private var name: String? = null
    private val resultViewModel: ResultViewModel by viewModels { ResultViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val resultAdapter = ResultAdapter()
        name = intent.getStringExtra("name")
        binding.rvResult.adapter = resultAdapter

        binding.ivResultBack.setOnClickListener {
            val intent = Intent(this, InitRoomActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        resultViewModel.getResultData.observe(this) {
            binding.data = it
            binding.tvResultMyName.text = name
        }

        resultViewModel.getResultItemData.observe(this) {
            resultAdapter.submitList(it)
        }

        lifecycleScope.launch { resultViewModel.getResultData() }
    }
}
