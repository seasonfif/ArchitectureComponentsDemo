package com.seasonfif.project.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.seasonfif.project.repository.StoryRepository
import com.seasonfif.project.data.Story

class StoryListViewModel : ViewModel(){

    var storyListLiveData : MutableLiveData<List<Story>> = StoryRepository().getStoryList()

    var loadmoreLiveData : MutableLiveData<List<Story>> = StoryRepository.loadmoreLiveData

    fun refreshStory() {
        storyListLiveData = StoryRepository().getStoryList()
    }

    fun loadmoreStory() {
        loadmoreLiveData = StoryRepository().loadmoreStory()
    }
}