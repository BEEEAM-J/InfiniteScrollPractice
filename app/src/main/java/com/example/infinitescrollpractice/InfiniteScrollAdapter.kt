package com.example.infinitescrollpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infinitescrollpractice.databinding.ItemRecyclerBinding
import com.example.infinitescrollpractice.databinding.ItemRecyclerLoadingBinding

enum class ItemViewType(val viewType: Int) {
    LOADING(0),
    ITEM(1)
}

class InfiniteScrollAdapter: ListAdapter<Data, RecyclerView.ViewHolder>(InfiniteScrollDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            ItemViewType.LOADING.viewType -> {
                return InfiniteScrollLoadingViewHoler(
                    ItemRecyclerLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            ItemViewType.ITEM.viewType -> {
                return InfiniteScrollViewHolder(
                    ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }

            else -> {
                throw Exception()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItem(position).title) {
            "" -> {
                (holder as InfiniteScrollLoadingViewHoler).bind(getItem(position))
            }
            else -> {
                (holder as InfiniteScrollViewHolder).bind(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).title) {
            "" -> {
                ItemViewType.LOADING.viewType
            }
            else -> {
                ItemViewType.ITEM.viewType
            }
        }
    }
}

class InfiniteScrollDiffCallback : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}