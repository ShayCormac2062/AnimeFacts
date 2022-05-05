package com.example.mywaifu.data.response

import com.example.mywaifu.domain.model.AnimeFact
import com.google.gson.annotations.SerializedName

data class AnimeWithFacts(
    @SerializedName("anime_img")
    val animeImg: String,
    val data: List<Fact>,
    val success: Boolean,
    @SerializedName("total_facts")
    val totalFacts: Int
) {
    fun toAnimeFact() = AnimeFact(
        animeImg,
        data
    )
}