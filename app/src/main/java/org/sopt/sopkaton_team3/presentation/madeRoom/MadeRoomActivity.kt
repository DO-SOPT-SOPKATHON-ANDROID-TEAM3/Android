package org.sopt.sopkaton_team3.presentation.madeRoom

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityMadeRoomBinding
import org.sopt.sopkaton_team3.util.binding.BindingActivity

class MadeRoomActivity : BindingActivity<ActivityMadeRoomBinding>(R.layout.activity_made_room) {
    private val viewModel: MadeRoomViewModel by viewModels { MadeRoomViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val madeRoomAdapter = MadeRoomAdapter(this)
        binding.rvMadeRoomUserList.adapter = madeRoomAdapter
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvMadeRoomUserList.addItemDecoration(dividerItemDecoration)


        viewModel.userList.observe(this) {
            binding.userList = it
            Log.e("TAG", "onCreate: $it", )
            Log.e("TAG", "onCreate: ${it.userList}", )
            madeRoomAdapter.submitList(it.userList)
        }

        lifecycleScope.launch { viewModel.loadUserList() }
    }
}