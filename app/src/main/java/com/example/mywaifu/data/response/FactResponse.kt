package com.example.mywaifu.data.response

import com.example.mywaifu.domain.model.Fact
import com.google.gson.annotations.SerializedName

data class FactResponse(
    val fact: String,
    @SerializedName("fact_id")
    val factId: Int
) {
    fun toFact() = Fact(fact)
}