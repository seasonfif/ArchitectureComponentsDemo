package com.seasonfif.architecturecomponentsdemo.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

class TimeViewModel : ViewModel() {

    var timeLiveData : MutableLiveData<Int> = MutableLiveData()

    var time = 0

    var stop = false

    fun updateTime(){
        Thread{
            run {
                while (!stop){
                    try {
                        Thread.sleep(1000)
                        time ++
                        timeLiveData.postValue(time)
                        Log.e("更新", "$time")
                    }catch (e : Throwable){
                        e.printStackTrace()
                    }
                }
            }
        }.start()
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("TimeViewModel", "onCleared")
        stop = true

    }
}