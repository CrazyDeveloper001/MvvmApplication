package com.io.practicemvvm.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.io.practicemvvm.data.network.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    @NetworkQualifier.BaseUrl
    fun provideBaseUrl() :String = "https://open-api.xyz/placeholder/"

    @Provides
    @Singleton
    fun provideGson():Gson{
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NetworkQualifier.BaseUrl baseUrl: String, gson: Gson) : Retrofit{
        return Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
    }

    @Provides
    @Singleton
    fun provideNetworkApi(retrofit: Retrofit): NetworkApi{
        return  retrofit.create(NetworkApi::class.java)
    }
}