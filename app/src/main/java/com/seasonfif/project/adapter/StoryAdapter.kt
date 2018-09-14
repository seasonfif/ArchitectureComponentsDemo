package com.seasonfif.project.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.seasonfif.project.OnRecyclerItemClickListener
import com.seasonfif.project.R
import com.seasonfif.project.data.Story

class StoryAdapter : RecyclerView.Adapter<Holder>(){

    private var mStoryList: ArrayList<Story> = ArrayList()

    private lateinit var listener : OnRecyclerItemClickListener<Story>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return if(mStoryList != null) mStoryList.size else 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var story = mStoryList[position]
        if (story != null){
            holder.bind(story)
            holder.itemView.setOnClickListener {
                listener.onItemClick(story)
            }
        }
    }

    fun setListener(listener : OnRecyclerItemClickListener<Story>){
        this.listener = listener
    }

    fun setData(storyList: List<Story>){
        mStoryList.addAll(storyList)
        notifyDataSetChanged()
    }

    fun clearData() {
        mStoryList.clear()
        notifyDataSetChanged()
    }
}