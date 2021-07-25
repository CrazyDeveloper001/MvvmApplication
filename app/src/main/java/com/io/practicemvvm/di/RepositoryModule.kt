package com.io.practicemvvm.di

import com.io.practicemvvm.data.network.NetworkApi
import com.io.practicemvvm.repository.MyFirstRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideRepository(networkApi: NetworkApi):MyFirstRepository{
        return MyFirstRepository(networkApi = networkApi)
    }
}