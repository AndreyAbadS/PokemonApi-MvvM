package com.example.pokedex.Data.Remote

import com.example.pokedex.Data.Model.PokemonInfo
import com.example.pokedex.Data.Model.PokemonListResult
import com.example.pokedex.Repository.webService

//llamamos al webService para buscar la informacion
class PokemonDataSource(private val webService: webService, private val id: PokemonInfo) {
    suspend fun getPokemon(): PokemonInfo = webService.getPokemon(id)

    suspend fun getPokemonList(): PokemonListResult = webService.getPokemonList(100, 0)

}