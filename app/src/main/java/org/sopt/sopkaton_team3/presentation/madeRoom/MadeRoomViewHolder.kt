package org.sopt.sopkaton_team3.presentation.madeRoom

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData
import org.sopt.sopkaton_team3.databinding.ItemUserInfoBinding

class MadeRoomViewHolder(private val binding: ItemUserInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: ResponseUserListData.UserInfo) {
        Log.e("TAG", "데이터 바인딩이딩딩")
        binding.userInfo = data
        binding.userImage.setImageResource(data.image)
    }
}