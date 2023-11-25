package org.sopt.sopkaton_team3.presentation

import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkaton_team3.databinding.ItemSlotBinding
import org.sopt.sopkaton_team3.presentation.model.Slot

class SlotViewHolder(
    private val binding: ItemSlotBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: Slot) {
        binding.tvItem.text = data.msg
    }
}