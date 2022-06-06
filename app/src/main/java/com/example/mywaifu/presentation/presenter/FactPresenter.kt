package com.example.mywaifu.presentation.presenter

import com.example.mywaifu.domain.usecase.GetAnimeFactsUseCase
import com.facebook.shimmer.ShimmerFrameLayout
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class FactPresenter @Inject constructor(
    private val getAnimeFactsUseCase: GetAnimeFactsUseCase
) : MvpPresenter<AnimeView>() {

    private val disposables = CompositeDisposable()

    override fun attachView(view: AnimeView?) {
        super.attachView(view)
    }

    override fun detachView(view: AnimeView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun onGetFactsClick(name: String, layout: ShimmerFrameLayout?) {
        disposables += getAnimeFactsUseCase(name)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading(layout)
            }
            .doAfterTerminate {
                viewState.hideLoading(layout)
            }
            .subscribeBy(onSuccess = {
                viewState.openAnimeWithFacts(getAnimeFactsUseCase(name).blockingGet())
            }, onError = { error ->
                error.printStackTrace()
            })
    }

}