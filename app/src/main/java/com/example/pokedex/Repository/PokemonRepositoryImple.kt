package com.example.pokedex.Repository

import com.example.pokedex.Data.Model.PokemonInfo
import com.example.pokedex.Data.Model.PokemonListResult
import com.example.pokedex.Data.Remote.PokemonDataSource

//instancia del dataSource
class PokemonRepositoryImple(private val dataSource: PokemonDataSource) : pokemonRepository {
    //llamamos desde el repositorio el dataSource
    override suspend fun getPokemon(): PokemonInfo = dataSource.getPokemon()

    override suspend fun getPokemonList(): PokemonListResult = dataSource.getPokemonList()

}