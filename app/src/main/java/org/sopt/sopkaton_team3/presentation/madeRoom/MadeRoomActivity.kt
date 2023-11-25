package org.sopt.sopkaton_team3.presentation.madeRoom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.coroutines.launch
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData
import org.sopt.sopkaton_team3.databinding.ActivityMadeRoomBinding
import org.sopt.sopkaton_team3.presentation.slot.SlotActivity
import org.sopt.sopkaton_team3.util.binding.BindingActivity

class MadeRoomActivity : BindingActivity<ActivityMadeRoomBinding>(R.layout.activity_made_room) {
    private val viewModel: MadeRoomViewModel by viewModels { MadeRoomViewModelFactory() }
    private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = intent.getStringExtra("name")
        val madeRoomAdapter = MadeRoomAdapter(this)
        binding.rvMadeRoomUserList.adapter = madeRoomAdapter
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvMadeRoomUserList.addItemDecoration(dividerItemDecoration)

        binding.btnMadeRoomJoin.setOnClickListener {
            Log.e("TAG", "페이지 이동")
            // 페이지 이동
            val intent = Intent(this, SlotActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

        binding.ivMadeRoomBack.setOnClickListener {
            finish()
        }

        viewModel.userList.observe(this) {
            binding.userList = ResponseUserListData(it)
            madeRoomAdapter.submitList(it)
        }

        lifecycleScope.launch { viewModel.loadUserList(name!!) }
    }
}