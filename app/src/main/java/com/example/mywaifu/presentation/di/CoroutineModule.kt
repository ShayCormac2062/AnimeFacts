package com.example.mywaifu.presentation.di

import com.example.mywaifu.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

    @Provides
    fun provideScope(): DispatcherProvider = DispatcherProvider()
}