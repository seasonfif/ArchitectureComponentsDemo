package com.seasonfif.project.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seasonfif.project.R
import com.seasonfif.project.data.Story

class StoryAdapter : RecyclerView.Adapter<Holder>(){

    private var mStoryList: ArrayList<Story> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return if(mStoryList != null) mStoryList.size else 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var story = mStoryList[position]
        holder.tvId.text = story.id
        holder.tvTitle.text = story.title
        Glide.with(holder.itemView).load(story.images[0]).into(holder.img)
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

class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){

    var img : ImageView = itemView.findViewById(R.id.img)
    var tvId : TextView = itemView.findViewById(R.id.tv_id)
    var tvTitle : TextView = itemView.findViewById(R.id.tv_title)

}