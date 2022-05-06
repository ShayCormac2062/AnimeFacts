package com.example.mywaifu.data.response

import com.example.mywaifu.domain.model.Data
import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("anime_id")
    val animeId: Int,
    @SerializedName("anime_img")
    val animeImg: String,
    @SerializedName("anime_name")
    val animeName: String
) {
    fun toData() = Data(animeImg, animeName)
}