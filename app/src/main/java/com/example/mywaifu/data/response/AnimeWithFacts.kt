package com.example.mywaifu.data.response

import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.Fact
import com.google.gson.annotations.SerializedName

data class AnimeWithFacts(
    @SerializedName("anime_img")
    val animeImg: String,
    val data: List<FactResponse>,
    val success: Boolean,
    @SerializedName("total_facts")
    val totalFacts: Int
) {
    fun toAnimeFact() = AnimeFact(
        animeImg,
        setupData(data)
    )

    private fun setupData(data: List<FactResponse>): List<Fact> {
        val result = arrayListOf<Fact>()
        for (fact in data) {
            result.add(fact.toFact())
        }
        return result
    }
}