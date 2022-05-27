package com.example.pokedex.Adapters.Concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Adapters.PokemonAdapter
import com.example.pokedex.Core.BaseConcactHolder
import com.example.pokedex.databinding.PokemonRowBinding

class PokemonConcactAdapter(private val pokemonAdapter: PokemonAdapter):RecyclerView.Adapter<BaseConcactHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcactHolder<*> {
        val itemBinding = PokemonRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcactViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcactHolder<*>, position: Int) {
        when(holder){
            is ConcactViewHolder -> holder.bind(pokemonAdapter)
        }
    }

    override fun getItemCount(): Int = 1
    private inner class ConcactViewHolder(val binding: PokemonRowBinding): BaseConcactHolder<PokemonAdapter>(binding.root){
        override fun bind(adapter: PokemonAdapter) {
            binding.rvListPokemon.adapter = adapter
        }

    }
}