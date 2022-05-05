package com.example.mywaifu.data

import com.example.mywaifu.data.retrofit.APIService
import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.domain.repository.AnimeRepository
import io.reactivex.rxjava3.core.Single

import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : AnimeRepository {

    override fun getAnimeList(): Single<AnimeList> =
        apiService.getAllAnime()
            .map { anime ->
                anime.toAnimeList()
            }

    override fun getAnimeFact(animeName: String): Single<AnimeFact> =
        apiService.getAnimeFacts(animeName)
            .map { fact ->
                fact.toAnimeFact()
            }


}