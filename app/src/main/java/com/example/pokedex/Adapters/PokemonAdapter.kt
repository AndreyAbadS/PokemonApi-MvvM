package com.example.pokedex.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.Core.BaseViewHolder
import com.example.pokedex.Data.Model.Result
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonAdapter(
    private val pokemonList: List<Result>,
    private val itemClickListener: OnPokemonClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnPokemonClickListener {
        fun onPokemonClick(pokemon: Result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PokemonViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onPokemonClick(pokemonList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PokemonViewHolder -> holder.bind(pokemonList[position])
        }
    }

    override fun getItemCount(): Int = pokemonList.size

    private inner class PokemonViewHolder(val binding: PokemonItemBinding, val context: Context) :
        BaseViewHolder<Result>(binding.root) {
        override fun bind(item: Result) {
            //Glide.with(context).load(item.url).centerCrop().into(binding.imagePokeball)
            binding.tvNamePokemon.text = item.name
        }

    }
}