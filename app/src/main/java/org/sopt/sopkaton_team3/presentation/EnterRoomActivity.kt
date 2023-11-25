package org.sopt.sopkaton_team3.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityEnterRoomBinding

class EnterRoomActivity : AppCompatActivity() {
    lateinit var binding : ActivityEnterRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterRoomBinding.inflate(layoutInflater)
        setContentView(binding.btnEnterRoom)

        enterRoomBtnListener()
    }
    private fun enterRoomBtnListener(){
        binding.btnEnterRoom.setOnClickListener{
            val intentEnterRoom = Intent(this, ) // 다음 액티비티 넣기
            startActivity(intentEnterRoom)
        }
    }
}