package com.example.pokedex.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface pokemonDao {
    @Query("SELECT * FROM pokemon_table ORDER BY name Desc")
    suspend fun getPokemon():List<pokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon:List<pokemonEntity>)
}