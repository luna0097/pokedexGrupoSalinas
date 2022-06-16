package com.example.pokedexgruposalinas.home.data.service

import com.example.gruposalinas.home.data.model.response.PokemonApi
import com.example.gruposalinas.home.data.model.response.PokemonInfo
import com.example.pokedexgruposalinas.home.data.model.response.PokemonAbility
import com.example.pokedexgruposalinas.home.data.model.response.PokemonEvolutionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("pokemon")
    fun getPokemons(@Query("limit") limit: Int): Call<PokemonApi>

    @GET("pokemon-species/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<PokemonInfo>

    @GET("pokemon/{name}")
    fun getPokemonHabilities(@Path("name") name: String): Call<PokemonAbility>

    @GET("{url}")
    fun getPokemonEvolutions(@Path("url") url: String): Call<PokemonEvolutionResponse>
}
