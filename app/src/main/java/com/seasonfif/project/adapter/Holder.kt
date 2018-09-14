package com.seasonfif.project.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seasonfif.project.R
import com.seasonfif.project.data.Story

class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){

    private var img : ImageView = itemView.findViewById(R.id.img)
    private var tvId : TextView = itemView.findViewById(R.id.tv_id)
    private var tvTitle : TextView = itemView.findViewById(R.id.tv_title)

    init {
        itemView.setOnClickListener {

        }
    }

    fun bind(story: Story) {
        tvId.text = story.id
        tvTitle.text = story.title
        Glide.with(itemView).load(story.images[0]).into(img)
    }
}