package com.example.infinitescrollpractice

import androidx.recyclerview.widget.RecyclerView
import com.example.infinitescrollpractice.databinding.ItemRecyclerLoadingBinding

class InfiniteScrollLoadingViewHoler(
    private val binding: ItemRecyclerLoadingBinding
): RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Data) {
        binding.executePendingBindings()
    }

}