package com.example.mywaifu.domain.usecase

import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.repository.AnimeRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetAnimeFactsUseCase @Inject constructor(
    private val repository: AnimeRepository
) {

    operator fun invoke(name: String): Single<AnimeFact> =
        repository.getAnimeFact(name)
         .subscribeOn(Schedulers.io())

}