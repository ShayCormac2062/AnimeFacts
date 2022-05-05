package com.example.mywaifu.domain.usecase

import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.domain.repository.AnimeRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetAllAnimeUseCase @Inject constructor(
    private val repository: AnimeRepository
) {

    operator fun invoke(): Single<AnimeList> = repository.getAnimeList()
        .subscribeOn(Schedulers.io())

}