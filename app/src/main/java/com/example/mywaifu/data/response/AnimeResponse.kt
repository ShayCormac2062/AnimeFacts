package com.example.mywaifu.data.response

import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.domain.model.Data

data class AnimeResponse(
    val data: List<DataResponse>,
    val success: Boolean
) {
    fun toAnimeList() = AnimeList(setupData(data))

    private fun setupData(data: List<DataResponse>): List<Data> {
        val result = arrayListOf<Data>()
        for (anime in data) {
            result.add(anime.toData())
        }
        return result
    }
}