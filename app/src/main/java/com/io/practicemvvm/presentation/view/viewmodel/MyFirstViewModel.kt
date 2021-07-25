package com.io.practicemvvm.presentation.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.practicemvvm.data.network.response.MyBlog
import com.io.practicemvvm.repository.MyFirstRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyFirstViewModel
    @Inject
    constructor(private val repository: MyFirstRepository) :ViewModel(){

     var _dataReceived : MutableLiveData<List<MyBlog>> = MutableLiveData()
    fun getPostFromRepository(){
        viewModelScope.launch{
            repository.getDataFromNetwork().catch {
                error->
                Log.e("First Fragment","error = ${error.message}")
            }.collect { result->
                _dataReceived.value= result
            }
        }
    }
}