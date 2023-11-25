package org.sopt.sopkaton_team3.presentation.enterRoom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityEnterRoomBinding
import org.sopt.sopkaton_team3.util.context.toast

class EnterRoomActivity : AppCompatActivity() {
    lateinit var binding : ActivityEnterRoomBinding
    private val enterRoomViewModel: EnterRoomViewModel by viewModels { EnterRoomViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterRoomBinding.inflate(layoutInflater)
        setContentView(binding.btnEnterRoom)

        initEnterRoomBtnListener()
        observeRequestSuccess()
    }
    private fun initEnterRoomBtnListener(){
        binding.btnEnterRoom.setOnClickListener{
            val code = (binding.evRoomInviteCode1.text.toString()) + (binding.evRoomInviteCode2.text.toString()) + (binding.evRoomInviteCode3.text.toString()) +(binding.evRoomInviteCode4.text.toString()) + (binding.evRoomInviteCode5.text.toString()) + (binding.evRoomInviteCode6.text.toString())
            val name = binding.etRoomName.text.toString()
            enterRoomViewModel.enter(code, name)
        }
    }
    private fun observeRequestSuccess(){
        enterRoomViewModel.requestSuccess.observe(this){
            if(it){
                toast("요청 성공")
                val intentEnterRoom = Intent(this, ) // 다음 액티비티 넣기
                startActivity(intentEnterRoom)
            }else{
                toast("요청 실패")
            }
        }
    }
}