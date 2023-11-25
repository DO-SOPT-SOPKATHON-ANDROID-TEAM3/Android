package org.sopt.sopkaton_team3.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.databinding.ActivityInitRoomBinding

class InitRoomActivity : AppCompatActivity() {
    lateinit var binding : ActivityInitRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMakeRoomBtnListener()
        initEnterRoomListener()
    }

    private fun initMakeRoomBtnListener(){
        binding.btnMakeRoom.setOnClickListener{
//            val intentMakeRoomActivity = Intent(this, ) // 다음 액티비티 넣기
//            startActivity(intentMakeRoomActivity)
        }
    }
    private fun initEnterRoomListener(){
        binding.btnEnterRoom.setOnClickListener{
//            val intentEnterRoomActivity = Intent(this, ) // 다음 액티비티 넣기
//            startActivity(intentEnterRoomActivity)
        }
    }
}