package org.sopt.sopkaton_team3.presentation.enterRoom

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkaton_team3.databinding.ActivityEnterRoomBinding
import org.sopt.sopkaton_team3.presentation.madeRoom.MadeRoomActivity

class EnterRoomActivity : AppCompatActivity() {
    lateinit var binding: ActivityEnterRoomBinding
    private val enterRoomViewModel: EnterRoomViewModel by viewModels { EnterRoomViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEnterRoomBtnListener()
        observeRequestSuccess()
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun initEnterRoomBtnListener() {
        binding.btnEnterRoom.setOnClickListener {
            val code =
                (binding.evRoomInviteCode1.text.toString()) + (binding.evRoomInviteCode2.text.toString()) + (binding.evRoomInviteCode3.text.toString()) + (binding.evRoomInviteCode4.text.toString()) + (binding.evRoomInviteCode5.text.toString()) + (binding.evRoomInviteCode6.text.toString())
            val name = binding.etRoomName.text.toString()
            enterRoomViewModel.enter(code, name)
        }
    }

    private fun observeRequestSuccess() {
        enterRoomViewModel.requestSuccess.observe(this) {
            if (it) {
                val intent = Intent(this, MadeRoomActivity::class.java)
                intent.putExtra("name", binding.etRoomName.text.toString())
                startActivity(intent)
            } else {
            }
        }
    }
}