package com.example.pokedex.Repository

import com.example.pokedex.Data.Model.Pokemon
import com.example.pokedex.Data.Model.PokemonList

//interface para buscar informacion al servidor
interface pokemonRepository {
    suspend fun getPokemon(pokemon:String): Pokemon
    suspend fun getPokemonList(): PokemonList
}