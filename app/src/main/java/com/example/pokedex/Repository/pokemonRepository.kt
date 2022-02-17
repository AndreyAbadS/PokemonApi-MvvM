package com.example.pokedex.Repository

import com.example.pokedex.Data.Model.PokemonInfo
import com.example.pokedex.Data.Model.PokemonListResult

//interface para buscar informacion al servidor
interface pokemonRepository {
    suspend fun getPokemon(): PokemonInfo
    suspend fun getPokemonList():PokemonListResult
}