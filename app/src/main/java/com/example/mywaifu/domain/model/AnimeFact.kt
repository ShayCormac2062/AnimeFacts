package com.example.mywaifu.domain.model

import com.example.mywaifu.data.response.Fact

data class AnimeFact(
    val animeImg: String,
    val data: List<Fact>,
)