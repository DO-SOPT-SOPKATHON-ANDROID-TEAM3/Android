package org.sopt.sopkaton_team3.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkaton_team3.data.model.response.ResultResponse
import org.sopt.sopkaton_team3.databinding.ItemResultBinding
import org.sopt.sopkaton_team3.util.view.ItemDiffCallback

class ResultAdapter(
) : ListAdapter<ResultResponse.Data.Other, ResultAdapter.ResultViewHolder>(
    ItemDiffCallback<ResultResponse.Data.Other>(
        onItemsTheSame = { old, new -> old.name == new.name },
        onContentsTheSame = { old, new -> old == new },
    ),
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ResultViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ResultResponse.Data.Other) {
            binding.data = data
        }
    }
}
