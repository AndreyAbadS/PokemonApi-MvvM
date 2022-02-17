package com.example.pokedex.Repository

import com.example.pokedex.Data.Model.PokemonInfo
import com.example.pokedex.Data.Model.PokemonListResult
import com.example.pokedex.Material.URLstatic
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Encargado de usar retrofit para traer datos del servidor
interface webService {
    //Buscar la informacion y de donde
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: PokemonInfo): PokemonInfo

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResult
}

object RetrofitClient {
    //lazy para inicializar en el momento que yo llame la funcion
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(URLstatic.Url_static)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(webService::class.java)
    }
}
