package com.example.pokedex.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [pokemonEntity::class], version = 1)
abstract class pokemonDatabase:RoomDatabase() {
    abstract fun getPokemonDao():pokemonDao
}