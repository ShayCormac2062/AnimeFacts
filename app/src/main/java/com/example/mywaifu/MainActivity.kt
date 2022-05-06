package com.example.mywaifu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mywaifu.databinding.ActivityMainBinding
import com.example.mywaifu.presentation.fragment.AnimeListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        begin()
    }

    private fun begin() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AnimeListFragment())
            .commit()
    }

}