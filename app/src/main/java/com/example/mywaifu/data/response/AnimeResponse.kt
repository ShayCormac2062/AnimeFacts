package com.example.mywaifu.data.response

import com.example.mywaifu.domain.model.AnimeList

data class AnimeResponse(
    val data: List<Data>,
    val success: Boolean
) {
    fun toAnimeList() = AnimeList(data)
}