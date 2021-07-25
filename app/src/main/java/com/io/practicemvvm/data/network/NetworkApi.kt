package com.io.practicemvvm.data.network

import com.io.practicemvvm.data.network.response.MyBlog
import retrofit2.http.GET

interface NetworkApi {

    @GET("blogs")
    suspend fun getMyBlogs():List<MyBlog>

}