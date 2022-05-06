package com.example.mywaifu.di

import android.app.Application
import android.content.Context
import com.example.mywaifu.data.AnimeRepositoryImpl
import com.example.mywaifu.data.retrofit.APIService
import com.example.mywaifu.domain.repository.AnimeRepository
import com.example.mywaifu.domain.usecase.GetAllAnimeUseCase
import com.example.mywaifu.domain.usecase.GetAnimeFactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAnimeRepository(
        apiService: APIService
    ): AnimeRepository = AnimeRepositoryImpl(apiService)

    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideGetAllAnimeUseCase(
        repository: AnimeRepository
    ): GetAllAnimeUseCase = GetAllAnimeUseCase(repository)

    @Provides
    fun provideGetAnimeFactsUseCase(
        repository: AnimeRepository
    ): GetAnimeFactsUseCase = GetAnimeFactsUseCase(repository)
}
