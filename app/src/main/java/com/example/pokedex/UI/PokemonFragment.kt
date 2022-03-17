package com.example.pokedex.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pokedex.Data.Remote.PokemonDataSource
import com.example.pokedex.Presentation.PokemonVIewModel
import com.example.pokedex.Presentation.PokemonViewModelFactory
import com.example.pokedex.R
import com.example.pokedex.Repository.PokemonRepositoryImple
import com.example.pokedex.Repository.webService
import com.example.pokedex.databinding.FragmentPokemonBinding

class PokemonFragment : Fragment(R.layout.fragment_pokemon) {
    private lateinit var binding: FragmentPokemonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokemonBinding.bind(view)
    }

}