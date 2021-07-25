package com.io.practicemvvm.utils.State

sealed class DataState<out R> {
    class onError(error: String) : DataState<Nothing>()
    object  onLoading : DataState<Nothing>()
    class  onSuccess<out T>(result: T) : DataState<T>()
}
