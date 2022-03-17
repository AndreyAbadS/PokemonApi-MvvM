package com.example.pokedex.Data.Local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class pokemonEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "base_experience")
    val base_experience: Int = -1,
    @ColumnInfo(name = "is_default")
    val is_default: Boolean = false,
    @ColumnInfo(name="name")
    val name: String = "",
    @ColumnInfo(name="order")
    val order: Int = -1,
    @ColumnInfo(name="weight")
    val weight: String = "",
        )