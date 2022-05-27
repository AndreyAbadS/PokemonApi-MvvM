package com.example.pokedex.Adapters.Concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Adapters.PokemonAdapter
import com.example.pokedex.Core.BaseConcactHolder
import com.example.pokedex.databinding.PokemonRowBinding

class PokemonDetailConcatAdapter (private val pokemonDetailConcatAdapter: PokemonDetailConcatAdapter):
    RecyclerView.Adapter<BaseConcactHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcactHolder<*> {
        val itemBinding = PokemonRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcactViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcactHolder<*>, position: Int) {
        when(holder){
            is ConcactViewHolder -> holder.bind(pokemonDetailConcatAdapter)
        }
    }

    override fun getItemCount(): Int = 1
    private inner class ConcactViewHolder(val binding: PokemonRowBinding): BaseConcactHolder<PokemonDetailConcatAdapter>(binding.root){
        override fun bind(adapter: PokemonDetailConcatAdapter) {
            binding.rvListPokemon.adapter = adapter
        }

    }
}