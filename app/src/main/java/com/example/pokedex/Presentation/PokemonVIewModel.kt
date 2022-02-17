package com.example.pokedex.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.pokedex.Core.Resource
import com.example.pokedex.Repository.pokemonRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

//el viewModel va a buscar la informacion al repositorio Interface
class PokemonVIewModel(private val repo:pokemonRepository):ViewModel(){
    fun fetchPokemonInfo()= liveData(Dispatchers.IO){
        //Emitir liveData a la UI
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getPokemon()))
        }catch (e:Exception){
            emit(Resource.Failed(e))
        }
    }
}
//instancia de repo para poder trabajar con la interfaz
class PokemonViewModelFactory(private val repo:pokemonRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(pokemonRepository::class.java).newInstance(repo)
    }

}