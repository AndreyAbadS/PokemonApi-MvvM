package com.example.pokedex.Data.Remote

import com.example.pokedex.Data.Model.Pokemon
import com.example.pokedex.Data.Model.PokemonList
import com.example.pokedex.Repository.webService

//llamamos al webService para buscar la informacion
class PokemonDataSource(private val pokemon:String,private val webService: webService) {
    suspend fun getPokemon(): Pokemon = webService.getPokemon(pokemon)

    suspend fun getPokemonList(): PokemonList = webService.getPokemonList(100,0)

}