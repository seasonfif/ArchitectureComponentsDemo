package com.seasonfif.project.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.seasonfif.project.data.Story

@Database(entities = [Story::class], version = RoomConst.DATABASE_VERSION, exportSchema = false)
//@TypeConverters(StringListConvert::class)
abstract class StoryDatabase : RoomDatabase(){

    abstract fun storyDao() : StoryDao

    companion object {

        @Volatile
        private var INSTANCE : StoryDatabase? = null

        fun getInstance(context: Context) : StoryDatabase = INSTANCE ?: synchronized(this){
            INSTANCE ?: buildStoryDatabase(context).also { INSTANCE = it }
        }

        private fun buildStoryDatabase(context: Context): StoryDatabase
                = Room.databaseBuilder(context, StoryDatabase::class.java, RoomConst.DB_NAME).build()
    }
}