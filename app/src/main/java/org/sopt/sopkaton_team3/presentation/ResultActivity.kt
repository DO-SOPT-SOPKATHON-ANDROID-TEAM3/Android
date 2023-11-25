package org.sopt.sopkaton_team3.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityResultBinding
import org.sopt.sopkaton_team3.util.binding.BindingActivity

class ResultActivity : BindingActivity<ActivityResultBinding>(R.layout.activity_result) {

    private val resultViewModel: ResultViewModel by viewModels { ResultViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val resultAdapter = ResultAdapter()
        binding.rvResult.adapter = resultAdapter

        resultViewModel.getResultData.observe(this) {
            binding.data = it
        }

        resultViewModel.getResultItemData.observe(this){
            resultAdapter.submitList(it)
        }

        lifecycleScope.launch { resultViewModel.getResultData() }
    }
}
