package com.example.infinitescrollpractice

import androidx.recyclerview.widget.RecyclerView
import com.example.infinitescrollpractice.databinding.ItemRecyclerBinding

class InfiniteScrollViewHolder(
    private val binding: ItemRecyclerBinding
): RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Data) {
        binding.apply {
            tvTitle.text = item.title
            tvContent.text = item.content
        }
        binding.executePendingBindings()
    }

}