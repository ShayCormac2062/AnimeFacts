package com.example.mywaifu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mywaifu.databinding.ViewFactCardviewBinding
import com.example.mywaifu.domain.model.Fact

class FactAdapter(private var factsList: List<Fact>) : RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    inner class FactViewHolder(
        private val binding: ViewFactCardviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Fact, position: Int) = with(binding) {
            tvFactIndex.text = "Fact #$position"
            tvFact.text = item.fact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder =
        FactViewHolder(
            ViewFactCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) =
        holder.bind(factsList[position], position + 1)

    override fun getItemCount(): Int = factsList.size

}