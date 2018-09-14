package com.seasonfif.project.repository

import android.arch.paging.DataSource
import com.seasonfif.project.data.Story

class StoryDataSourceFactory : DataSource.Factory<String, Story>(){
    /**
     * Create a DataSource.
     *
     *
     * The DataSource should invalidate itself if the snapshot is no longer valid. If a
     * DataSource becomes invalid, the only way to query more data is to create a new DataSource
     * from the Factory.
     *
     *
     * [LivePagedListBuilder] for example will construct a new PagedList and DataSource
     * when the current DataSource is invalidated, and pass the new PagedList through the
     * `LiveData<PagedList>` to observers.
     *
     * @return the new DataSource.
     */
    override fun create(): DataSource<String, Story> {
        return RemoteDataSource()
    }

}