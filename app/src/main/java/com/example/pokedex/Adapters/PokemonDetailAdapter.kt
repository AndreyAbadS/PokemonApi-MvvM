package com.example.pokedex.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.Core.BaseViewHolder
import com.example.pokedex.Data.Model.Pokemon
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonDetailAdapter(
    private val pokemon: List<Pokemon>,
    private val itemClickListener: OnPokemonClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnPokemonClickListener {
        fun onPokemonClick(pokemon: Pokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PokemonViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onPokemonClick(pokemon[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PokemonViewHolder -> holder.bind(pokemon[position])
        }
    }

    override fun getItemCount(): Int = pokemon.size

    private inner class PokemonViewHolder(val binding: PokemonItemBinding, val context: Context) :
        BaseViewHolder<Pokemon>(binding.root) {
        override fun bind(item: Pokemon) {
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${item.sprites?.frontdefault}")
                .centerCrop().into(binding.imagePokeball)
            binding.tvNamePokemon.text = item.name
            binding.tvNoPokemon.text = item.order.toString()
        }

    }
}