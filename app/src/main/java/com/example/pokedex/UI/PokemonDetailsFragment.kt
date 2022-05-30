package com.example.pokedex.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pokedex.Core.Resource
import com.example.pokedex.Data.Remote.PokemonDataSource
import com.example.pokedex.Presentation.PokemonVIewModel
import com.example.pokedex.Presentation.PokemonViewModelFactory
import com.example.pokedex.R
import com.example.pokedex.Repository.PokemonRepositoryImple
import com.example.pokedex.Repository.RetrofitClient
import com.example.pokedex.databinding.FragmentPokemonDetailsBinding

class PokemonDetailsFragment : Fragment(R.layout.fragment_pokemon_details) {
    private lateinit var binding: FragmentPokemonDetailsBinding
    private val args by navArgs<PokemonDetailsFragmentArgs>()
    private val viewmodel by viewModels<PokemonVIewModel> {
        PokemonViewModelFactory(
            PokemonRepositoryImple(
                PokemonDataSource(RetrofitClient.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokemonDetailsBinding.bind(view)
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_pokemonDetailsFragment_to_pokemonFragment)
            }
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), onBackPressedCallback)


        viewmodel.fetchPokemonInfo(args.name).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    binding.tvNamePokemonDetails.text = result.data.name
                    binding.tvBaseExperience.text = result.data.base_experience.toString()
                    binding.tvHeight.text = result.data.height.toString()
                    binding.tvWeight.text = result.data.weight.toString()
                    binding.ivPokemon.visibility = View.VISIBLE
                    Glide.with(requireContext()).load("${result.data.sprites?.frontdefault}").centerCrop().into(binding.ivPokemon)
                    if (result.data.is_default == true){
                        binding.tvDefault.text = "Yes"
                    }else{
                        binding.tvDefault.text = "No"
                    }

                }
                is Resource.Failed -> {
                    binding.progressbar.visibility = View.GONE
                    Log.d("error","${result.exception}")
                }
            }
        })
    }

}