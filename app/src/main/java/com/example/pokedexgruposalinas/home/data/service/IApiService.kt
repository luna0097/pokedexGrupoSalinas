package com.example.pokedexgruposalinas.home.data.service

import com.example.gruposalinas.home.data.model.response.PokemonApi
import com.example.gruposalinas.home.data.model.response.PokemonInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("pokemon")
    fun getPokemons(@Query("limit") limit: Int): Call<PokemonApi>

    @GET("pokemon-species/{name}/")
    fun getPokemonByName(@Query("name") name: String): Call<PokemonInfo>
}

//https://pokeapi.co/api/v2/pokemon-species/pikachu/