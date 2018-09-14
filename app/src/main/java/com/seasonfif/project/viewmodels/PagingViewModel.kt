package com.seasonfif.project.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.util.Log
import com.seasonfif.project.data.Story
import com.seasonfif.project.repository.StoryDataSourceFactory

class PagingViewModel : ViewModel(){

    private val config = PagedList.Config.Builder().setPageSize(10).build()

    val storyListLiveData = LivePagedListBuilder<String, Story>(StoryDataSourceFactory(), config)
            .setBoundaryCallback(ListBoundaryCallback<Story>())
            .build()
}

class ListBoundaryCallback<Value> : PagedList.BoundaryCallback<Value>(){

    /**
     * Called when zero items are returned from an initial load of the PagedList's data source.
     */
    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        Log.e("ListBoundaryCallback", "onZeroItemsLoaded")
    }

    /**
     * Called when the item at the end of the PagedList has been loaded, and access has
     * occurred within [Config.prefetchDistance] of it.
     *
     *
     * No more data will be appended to the PagedList after this item.
     *
     * @param itemAtEnd The first item of PagedList
     */
    override fun onItemAtEndLoaded(itemAtEnd: Value) {
        super.onItemAtEndLoaded(itemAtEnd)
        Log.e("ListBoundaryCallback", "onItemAtEndLoaded")
    }

    /**
     * Called when the item at the front of the PagedList has been loaded, and access has
     * occurred within [Config.prefetchDistance] of it.
     *
     *
     * No more data will be prepended to the PagedList before this item.
     *
     * @param itemAtFront The first item of PagedList
     */
    override fun onItemAtFrontLoaded(itemAtFront: Value) {
        super.onItemAtFrontLoaded(itemAtFront)
        Log.e("ListBoundaryCallback", "onItemAtFrontLoaded")
    }
}