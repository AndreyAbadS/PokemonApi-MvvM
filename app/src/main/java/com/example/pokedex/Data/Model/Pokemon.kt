package com.example.pokedex.Data.Model

import com.google.gson.annotations.SerializedName

//datos que rellenaremos desde la api
data class Pokemon(
    val id: Int,
    val base_experience: Int = -1,
    val height: Int = -1,
    val is_default: Boolean = false,
    val name: String = "",
    val order: Int = -1,
    val weight: String = "",
    val sprites: Sprites?
)

data class Sprites(
    @SerializedName("front_default")
    val frontdefault: String? = "",
    @SerializedName("front_shiny")
    val frontshiny: String? = ""
)

//Lista de pokemon
data class PokemonList(
    val count: Int = -1,
    val next: String = "",
    val previous: String = "",
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)

