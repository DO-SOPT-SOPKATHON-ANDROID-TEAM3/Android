package org.sopt.sopkaton_team3.presentation.example

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityExampleBinding
import org.sopt.sopkaton_team3.util.binding.BindingActivity
import org.sopt.sopkaton_team3.util.context.toast
import org.sopt.sopkaton_team3.util.view.UiState

class ExampleActivity : BindingActivity<ActivityExampleBinding>(R.layout.activity_example) {
    private val viewModel: ExampleViewModel by viewModels { ExampleViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getDummyResult.observe(this) {
            binding.data = it
        }

        viewModel.errorResult.observe(this) {
            this.toast(it)
        }

        viewModel.getDummyState.observe(this) { state ->
            when (state) {
                is UiState.Success -> binding.data = state.data
                is UiState.Failure -> this.toast(state.msg)
                else -> {}//Empty or Loading
            }
        }

        lifecycleScope.launch { viewModel.getData() }
    }
}