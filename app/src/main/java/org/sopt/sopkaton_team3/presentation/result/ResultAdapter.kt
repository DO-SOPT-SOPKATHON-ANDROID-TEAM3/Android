package org.sopt.sopkaton_team3.presentation.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.sopkaton_team3.R
import org.sopt.sopkaton_team3.data.model.response.ResultResponse
import org.sopt.sopkaton_team3.databinding.ItemResultBinding
import org.sopt.sopkaton_team3.util.view.ItemDiffCallback

class ResultAdapter() : ListAdapter<ResultResponse.Data.Other, ResultAdapter.ResultViewHolder>(
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
        val resourceId: Int = when (position) {
            0 -> R.drawable.img_watermelon_profile
            1 -> R.drawable.img_graph_profile
            2 -> R.drawable.img_diamond_profile
            3 -> R.drawable.img_orange_profile
            4 -> R.drawable.img_seven_profile
            else -> R.drawable.img_cherry_profile
        }

        holder.onBind(getItem(position), resourceId)

        if (position == 0) {
            holder.binding.tvResultPosition.text = "방장"
        }
    }

    inner class ResultViewHolder(internal val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ResultResponse.Data.Other, id: Int) {
            binding.data = data
            binding.tvResultImage.load(id)
        }
    }
}
