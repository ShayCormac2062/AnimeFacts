package com.example.mywaifu.data

import com.example.mywaifu.data.retrofit.APIService
import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.domain.repository.AnimeRepository
import io.reactivex.rxjava3.core.Single
import java.lang.StringBuilder
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

    private fun transformFromCamel(name: String): String {
        val builder = StringBuilder(name.replace("_", " ")).also {
            it.setCharAt(0, Character.toUpperCase(name[0]))
        }
        return builder.toString()
    }

    private fun transformToCamel(name: String): String {
        return name.replace(' ', '_').lowercase(Locale.getDefault())
    }

}