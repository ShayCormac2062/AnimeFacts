package com.example.mywaifu.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mywaifu.R
import com.example.mywaifu.databinding.FragmentAnimeListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeListFragment : Fragment() {

    private var binding: FragmentAnimeListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}