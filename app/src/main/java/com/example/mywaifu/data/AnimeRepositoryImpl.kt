package com.example.mywaifu.data

import com.example.mywaifu.data.retrofit.APIService
import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.domain.repository.AnimeRepository
import io.reactivex.rxjava3.core.Single
import java.util.*

import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : AnimeRepository {

    override fun getAnimeList(): Single<AnimeList> =
        apiService.getAllAnime()
            .map { anime ->
                anime.toAnimeList().also {
                    for (response in it.animeList) {
                        response.animeName = transformFromCamel(response.animeName)
                    }
                }
            }

    override fun getAnimeFact(animeName: String): Single<AnimeFact> =
        apiService.getAnimeFacts(transformToCamel(animeName))
            .map { fact ->
                fact.toAnimeFact()
            }

    private fun transformFromCamel(name: String): String =
        name.replace("_", " ").also {
            it[0].minus(32)
        }

    private fun transformToCamel(name: String): String =
        name.lowercase(Locale.getDefault()).replace('_', ' ')

}