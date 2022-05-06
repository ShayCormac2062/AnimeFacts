package com.example.mywaifu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mywaifu.databinding.ViewAnimeCardviewBinding
import com.example.mywaifu.domain.model.Data
import coil.load

class AnimeAdapter(private var dataList: List<Data>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    var onClick: ((String) -> Unit)? = null

    inner class AnimeViewHolder(
        private val binding: ViewAnimeCardviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data, position: Int) = with(binding) {
            ivAnimeImage.load(item.animeImg)
            tvAnimeName.text = item.animeName
            tvAnimeId.text = "Anime ID: $position"
            animeCardview.setOnClickListener {
                onClick?.invoke(item.animeName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder =
        AnimeViewHolder(
            ViewAnimeCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) =
        holder.bind(dataList[position], position + 1)

    override fun getItemCount(): Int = dataList.size

}