package com.io.practicemvvm.repository

import android.util.Log
import com.io.practicemvvm.data.network.NetworkApi
import com.io.practicemvvm.data.network.response.MyBlog
import com.io.practicemvvm.utils.State.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MyFirstRepository
@Inject
constructor(private  val networkApi:NetworkApi) {

    suspend  fun getDataFromNetwork(): Flow<List<MyBlog>?> = flow {
        try{
            var result=  networkApi.getMyBlogs()
            Log.e("First OnSuccess","Success on Repos ")
            emit(
                result
            )
        }catch (e:Exception){
            Log.e("First Fragment","Exception on Repository = ${e.message} ")
            emit(
              throw e
            )
        }
    }.flowOn(Dispatchers.IO)



}
