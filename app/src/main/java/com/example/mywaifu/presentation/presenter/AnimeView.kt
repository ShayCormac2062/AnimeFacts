package com.example.mywaifu.presentation.presenter

import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import com.facebook.shimmer.ShimmerFrameLayout
import moxy.MvpView
import moxy.viewstate.strategy.alias.*

@AddToEndSingle
interface AnimeView : MvpView {

    fun showAllAnime(list: AnimeList)

    fun showLoading(layout: ShimmerFrameLayout?)

    fun hideLoading(layout: ShimmerFrameLayout?)

    @OneExecution
    fun openAnimeWithFacts(fact: AnimeFact)

}