package com.example.mywaifu.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mywaifu.R
import com.example.mywaifu.databinding.FragmentAnimeFactBinding
import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.presentation.adapter.FactAdapter
import com.example.mywaifu.presentation.presenter.AnimeView
import com.example.mywaifu.presentation.presenter.FactPresenter
import com.facebook.shimmer.ShimmerFrameLayout
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class AnimeFactFragment : MvpAppCompatFragment(), AnimeView {

    @Inject
    @InjectPresenter
    lateinit var presenter: FactPresenter

    @ProvidePresenter
    fun providePresenter(): FactPresenter = presenter

    private var binding: FragmentAnimeFactBinding? = null
    private var animeName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeFactBinding.inflate(layoutInflater)
        animeName = arguments?.getString("name") ?: ""
        presenter.onGetFactsClick(animeName.toString(), binding?.slFacts)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            tvAnimeName.text = animeName
            btnBack.setOnClickListener {
                showAllAnime(AnimeList(arrayListOf()))
            }
        }
    }

    override fun showLoading(layout: ShimmerFrameLayout?) {
        layout?.run {
            startShimmer()
            visibility = View.VISIBLE
        }
        binding?.rvFacts?.visibility = View.INVISIBLE
    }

    override fun hideLoading(layout: ShimmerFrameLayout?) {
        layout?.run {
            stopShimmer()
            visibility = View.GONE
        }
        binding?.rvFacts?.visibility = View.VISIBLE
    }

    override fun openAnimeWithFacts(fact: AnimeFact) {
        binding?.run {
            rvFacts.apply {
                layoutManager = LinearLayoutManager(context).apply {
                    orientation = RecyclerView.VERTICAL
                }
                adapter = FactAdapter(fact.data)
            }
            ivAnimeImage.load(fact.animeImg)
        }
    }

    override fun showAllAnime(list: AnimeList) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, AnimeListFragment())
            .commit()
    }
}