package com.seasonfif.architecturecomponentsdemo.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class TestLifecycle : LifecycleObserver {

    val TAG : String = "TestLifecycle"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create(){
        Log.e(TAG, "onCreate()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause(){
        Log.e(TAG, "onPause()")
    }
}