package com.example.mywaifu.data.response

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("anime_id")
    val animeId: Int,
    @SerializedName("anime_img")
    val animeImg: String,
    @SerializedName("anime_name")
    val animeName: String
)