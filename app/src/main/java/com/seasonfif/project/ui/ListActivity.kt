package com.seasonfif.project.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.seasonfif.project.OnRecyclerItemClickListener
import com.seasonfif.project.R
import com.seasonfif.project.adapter.StoryAdapter
import com.seasonfif.project.data.Story
import com.seasonfif.project.viewmodels.StoryListViewModel
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(){

    private lateinit var viewModel : StoryListViewModel

    private lateinit var adapter : StoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        viewModel = ViewModelProviders.of(this).get(StoryListViewModel::class.java)

        adapter = StoryAdapter()

        adapter.setListener(object : OnRecyclerItemClickListener<Story> {
            override fun onItemClick(t: Story) {
                startActivity(Intent(this@ListActivity, PagingListActivity::class.java))
            }
        })

        recycler_view.adapter = adapter

        viewModel.storyListLiveData.observe(this, Observer {
            if (refresh.isRefreshing){
                refresh.isRefreshing = false
            }
            adapter.setData(it!!)
        })

        viewModel.loadmoreLiveData.observe(this, Observer {
            if (refresh.isRefreshing){
                refresh.isRefreshing = false
            }
            adapter.setData(it!!)
        })

        setUpRefresh()

        setUpLoadmore()
    }


    private fun setUpRefresh() {
        refresh.setOnRefreshListener {
            adapter.clearData()
            viewModel.refreshStory()
        }

    }

    private fun setUpLoadmore() {
        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                val layoutManager = recyclerView?.layoutManager as LinearLayoutManager
                val lastPosition = layoutManager
                        .findLastCompletelyVisibleItemPosition()
                if (lastPosition == adapter.itemCount - 1) {
                    viewModel.loadmoreStory()
                }
            }
        })
    }
}
