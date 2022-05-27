package com.example.pokedex.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokedex.Core.Resource
import com.example.pokedex.Data.Remote.PokemonDataSource
import com.example.pokedex.Presentation.PokemonVIewModel
import com.example.pokedex.Presentation.PokemonViewModelFactory
import com.example.pokedex.R
import com.example.pokedex.Repository.PokemonRepositoryImple
import com.example.pokedex.Repository.RetrofitClient
import com.example.pokedex.Repository.webService
import com.example.pokedex.databinding.FragmentPokemonBinding

class PokemonFragment : Fragment(R.layout.fragment_pokemon) {
    private lateinit var binding: FragmentPokemonBinding
    private val viewmodel by viewModels<PokemonVIewModel> {
        PokemonViewModelFactory(
            PokemonRepositoryImple(
                PokemonDataSource(RetrofitClient.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokemonBinding.bind(view)

        viewmodel.fetchPokemonInfo("ditto").observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("livedata","Loading")
                }
                is Resource.Success -> {
                    Log.d("livedata","${result.data}")
                }
                is Resource.Failed -> {
                    Log.d("error","${result.exception}")
                }
            }
        })
        viewmodel.fetchList().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("livedata2","Loading")
                }
                is Resource.Success -> {
                    Log.d("livedata2","${result.data}")
                }
                is Resource.Failed -> {
                    Log.d("error2","${result.exception}")
                }
            }
        })
    }

}