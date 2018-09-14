package com.seasonfif.project.repository

import android.arch.lifecycle.MutableLiveData
import com.seasonfif.project.data.Bean
import com.seasonfif.project.data.Story
import com.seasonfif.project.netapi.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoryRepository {

    fun getStoryList() : MutableLiveData<List<Story>>{
        ApiManager.create().getLatestNews().enqueue(object : Callback<Bean>{
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<Bean>, t: Throwable) {

            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<Bean>, response: Response<Bean>) {
                if (response.isSuccessful){
                    storyListLiveData.value = response.body()?.stories
                    date = response.body()?.date
                }
            }

        })

        return storyListLiveData
    }

    fun loadmoreStory(): MutableLiveData<List<Story>> {

        ApiManager.create().getTheDaily(date!!).enqueue(object : Callback<Bean>{

            override fun onFailure(call: Call<Bean>, t: Throwable) {

            }

            override fun onResponse(call: Call<Bean>, response: Response<Bean>) {
                if (response.isSuccessful){
                    loadmoreLiveData.value = response.body()?.stories
                    date = response.body()?.date
                }
            }

        })

        return loadmoreLiveData
    }

    companion object {
        var date : String? = null
        var storyListLiveData: MutableLiveData<List<Story>> = MutableLiveData()
        var loadmoreLiveData: MutableLiveData<List<Story>> = MutableLiveData()
    }
}