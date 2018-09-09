package com.seasonfif.architecturecomponentsdemo.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.seasonfif.architecturecomponentsdemo.R
import com.seasonfif.architecturecomponentsdemo.lifecycle.TestLifecycle
import com.seasonfif.architecturecomponentsdemo.viewmodel.Model
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(TestLifecycle())

        loadData()
        switchFragment(null, FeedListFragment())
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container1, FeedListFragment()).commit()
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container2, DetailFragment()).commit()
    }

    fun switchFragment(from : Fragment?, to: Fragment){
        if (from != null){
            supportFragmentManager.beginTransaction().hide(from).commit()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container1, to).commit()
    }

    companion object {
        lateinit var model : Model

        fun loadData(){
            var builder : OkHttpClient.Builder = OkHttpClient.Builder()
            builder.connectTimeout(20, TimeUnit.SECONDS)
            builder.readTimeout(20, TimeUnit.SECONDS)
            builder.writeTimeout(20, TimeUnit.SECONDS)
            var okHttpClient : OkHttpClient = builder.build()

            var requestBuilder : Request.Builder = Request.Builder()
            requestBuilder.url("http://gank.io/api/xiandu/categories")
            var request : Request = requestBuilder.build()
            var callback : Callback = object : Callback{
                override fun onFailure(call: Call?, e: IOException?) {
                    e?.printStackTrace()
                }

                override fun onResponse(call: Call?, response: Response?) {
                    if (response!!.isSuccessful){
                        var json = response.body().string()
                        model = Gson().fromJson(json, Model::class.java)
                        Log.e("onResponse", "result:"+ model.error + json)
                    }
                }
            }
            okHttpClient.newCall(request).enqueue(callback)
        }
    }
}
