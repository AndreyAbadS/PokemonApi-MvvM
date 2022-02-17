package com.example.pokedex.Core

import java.lang.Exception

//Retornar estados genericos
sealed class Resource<out T> {
    //Vacio por que no lleva ningun mensaje
    class Loading<out T>:Resource<T>()
    data class Success<out T>(val data:T):Resource<T>()
    data class Failed(val exception: Exception):Resource<Nothing>()
}