package org.sopt.sopkaton_team3.presentation.madeRoom

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.sopkaton_team3.data.model.response.ResponseUserListData.UserInfo
import org.sopt.sopkaton_team3.databinding.ItemUserInfoBinding

import org.sopt.sopkaton_team3.util.view.ItemDiffCallback

class MadeRoomAdapter(context: Context) :
    ListAdapter<UserInfo, MadeRoomViewHolder>(
        UserInfoDiffCallback
    ) {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MadeRoomViewHolder {
        val binding = ItemUserInfoBinding.inflate(inflater, parent, false)
        return MadeRoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MadeRoomViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount() = currentList.size

    companion object {
        private val UserInfoDiffCallback =
            ItemDiffCallback<UserInfo>(
                onItemsTheSame = { old, new -> old.name == new.name },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}