package com.seasonfif.architecturecomponentsdemo.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class DataViewModel : ViewModel() {

    var selected : MutableLiveData<Result> = MutableLiveData()

    set(value) {
        field = value
    }

    get() = field

    override fun onCleared() {
        super.onCleared()
    }
}