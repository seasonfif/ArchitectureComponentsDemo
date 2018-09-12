package com.seasonfif.project.netapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private const val url = "https://news-at.zhihu.com/"

    fun create() : ApiService {
        var builder = Retrofit.Builder()
        return builder.baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

}
