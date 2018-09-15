package com.seasonfif.project.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.seasonfif.project.data.Story

@Dao
interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stories : List<Story>)


    @Query(RoomConst.QUERY)
    fun getStoriesById(date : String) : List<Story>
}