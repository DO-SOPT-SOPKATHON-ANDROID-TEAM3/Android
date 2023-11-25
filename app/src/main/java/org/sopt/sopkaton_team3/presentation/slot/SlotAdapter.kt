package org.sopt.sopkaton_team3.presentation.slot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.sopkaton_team3.databinding.ItemSlotBinding
import org.sopt.sopkaton_team3.presentation.model.Slot
import org.sopt.sopkaton_team3.util.view.ItemDiffCallback

class SlotAdapter : ListAdapter<Slot, SlotViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotViewHolder {
        val binding = ItemSlotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SlotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlotViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemCount(): Int {
        return 6
    }

    companion object {
        private val DiffUtil = ItemDiffCallback<Slot>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new }
        )
        private const val UNKNOWN_TYPE_EXCEPTION = "UNKNOWN_TYPE"
    }
}