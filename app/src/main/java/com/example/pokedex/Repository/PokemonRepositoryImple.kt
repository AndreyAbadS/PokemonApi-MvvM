package com.example.pokedex.Repository

import com.example.pokedex.Data.Model.Pokemon
import com.example.pokedex.Data.Model.PokemonList
import com.example.pokedex.Data.Remote.PokemonDataSource

//instancia del dataSource
class PokemonRepositoryImple(private val dataSource: PokemonDataSource) : pokemonRepository {
    //llamamos desde el repositorio el dataSource
    override suspend fun getPokemon(): Pokemon = dataSource.getPokemon()

    override suspend fun getPokemonList(): PokemonList = dataSource.getPokemonList()

}