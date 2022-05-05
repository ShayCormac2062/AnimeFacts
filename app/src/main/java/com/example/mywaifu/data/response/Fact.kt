package com.example.mywaifu.data.response

import com.google.gson.annotations.SerializedName

data class Fact(
    val fact: String,
    @SerializedName("fact_id")
    val factId: Int
)