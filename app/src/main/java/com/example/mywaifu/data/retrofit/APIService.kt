package com.example.mywaifu.data.retrofit

import com.example.mywaifu.data.response.AnimeResponse
import com.example.mywaifu.data.response.AnimeWithFacts
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("api/v1")
    fun getAllAnime(): Single<AnimeResponse>

    @GET("api/v1/:{animeName}")
    fun getAnimeFacts(@Query("anime_name") animeName: String): Single<AnimeWithFacts>
}