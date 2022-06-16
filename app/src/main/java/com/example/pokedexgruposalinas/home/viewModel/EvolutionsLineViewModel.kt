package com.example.pokedexgruposalinas.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gruposalinas.home.data.model.response.PokemonInfo
import com.example.pokedexgruposalinas.home.data.service.IApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EvolutionsLineViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: IApiService = retrofit.create(IApiService::class.java)

    val pokemonInfo = MutableLiveData<PokemonInfo>()
}