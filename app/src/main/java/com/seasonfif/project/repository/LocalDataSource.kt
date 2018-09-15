package com.seasonfif.project.repository

import android.arch.paging.PageKeyedDataSource
import com.seasonfif.project.data.Story

class LocalDataSource : PageKeyedDataSource<String, Story>(){

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, Story>) {


    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Story>) {


    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Story>) {

    }
}