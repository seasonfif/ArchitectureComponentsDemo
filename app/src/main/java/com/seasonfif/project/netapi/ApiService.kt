package com.seasonfif.project.netapi

import com.seasonfif.project.data.Bean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/4/news/latest")
    fun getLatestNews(): Call<Bean>

    @GET("/api/4/news/before/{date}")
    fun getTheDaily(@Path("date") date: String): Call<Bean>

}