package com.seasonfif.project.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seasonfif.project.R
import com.seasonfif.project.data.Story

class StoryPagingAdapter : PagedListAdapter<Story, Holder>(storyDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var story = getItem(position)
        if (story != null){
            holder.bind(story)
        }
    }

    companion object {

        val storyDiffCallback = object : DiffUtil.ItemCallback<Story>(){
            override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
                return oldItem == newItem
            }

        }
    }
}