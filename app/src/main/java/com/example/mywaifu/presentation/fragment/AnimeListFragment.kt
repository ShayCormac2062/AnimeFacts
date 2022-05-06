package com.example.mywaifu.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mywaifu.R
import com.example.mywaifu.databinding.FragmentAnimeListBinding
import com.example.mywaifu.domain.model.AnimeFact
import com.example.mywaifu.domain.model.AnimeList
import com.example.mywaifu.presentation.adapter.AnimeAdapter
import com.example.mywaifu.presentation.presenter.AnimePresenter
import com.example.mywaifu.presentation.presenter.AnimeView
import com.facebook.shimmer.ShimmerFrameLayout
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class AnimeListFragment : MvpAppCompatFragment(), AnimeView {

    private var binding: FragmentAnimeListBinding? = null

    @Inject
    @InjectPresenter
    lateinit var presenter: AnimePresenter

    @ProvidePresenter
    fun providePresenter(): AnimePresenter = presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onGetAllAnimeClick(binding?.slAnime)
    }

    override fun showAllAnime(list: AnimeList) {
        binding?.rvAllAnime?.apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = RecyclerView.VERTICAL
            }
            adapter = AnimeAdapter(list.animeList).apply {
                onClick = {
                    val bundle = Bundle().apply {
                        putString("name", it)
                    }
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, AnimeFactFragment().apply {
                            arguments = bundle
                        })
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun showLoading(layout: ShimmerFrameLayout?) {
        layout?.run {
            startShimmer()
            visibility = View.VISIBLE
        }
        binding?.rvAllAnime?.visibility = View.INVISIBLE
    }

    override fun hideLoading(layout: ShimmerFrameLayout?) {
        layout?.run {
            stopShimmer()
            visibility = View.GONE
        }
        binding?.rvAllAnime?.visibility = View.VISIBLE
    }

    override fun openAnimeWithFacts(fact: AnimeFact) {}
}