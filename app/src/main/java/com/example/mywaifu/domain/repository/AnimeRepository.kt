package com.example.mywaifu.domain.repository

import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import io.reactivex.rxjava3.core.Single

interface AnimeRepository {

    fun getAnimeList(): Single<AnimeList>
    fun getAnimeFact(animeName: String): Single<AnimeFact>
}