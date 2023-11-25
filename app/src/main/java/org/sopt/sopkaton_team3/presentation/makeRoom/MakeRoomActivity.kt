package org.sopt.sopkaton_team3.presentation.makeRoom

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityMakeRoomBinding
import org.sopt.sopkaton_team3.util.binding.BindingActivity
import org.sopt.sopkaton_team3.util.context.toast

class MakeRoomActivity : BindingActivity<ActivityMakeRoomBinding>(R.layout.activity_make_room) {
    private val viewModel: MakeRoomViewModel by viewModels { MakeRoomViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.userNameSuccess.observe(this) {
            if (it) {
                // 페이지 이동
            } else {
                toast("실패!!!!!!!!!!!!!!")
            }
        }

        binding.btnCreateRoom.setOnClickListener {
            lifecycleScope.launch {
                viewModel.createRoomBtn(binding.tvMakeRoomNameTitle.text.toString())
            }
        }
    }
}