package com.seasonfif.project.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.seasonfif.project.R
import com.seasonfif.project.adapter.StoryPagingAdapter
import com.seasonfif.project.viewmodels.PagingViewModel
import kotlinx.android.synthetic.main.paging_activity.*

class PagingListActivity : AppCompatActivity(){

    private val viewModel : PagingViewModel by lazy(LazyThreadSafetyMode.NONE){
        ViewModelProviders.of(this).get(PagingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paging_activity)

        val adapter = StoryPagingAdapter()

        recycler_view.adapter = adapter

        viewModel.storyListLiveData.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}