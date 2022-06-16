package com.example.pokedexgruposalinas.home.data.service

import com.example.gruposalinas.home.data.model.response.PokemonApi
import com.example.gruposalinas.home.data.model.response.PokemonInfo
import com.example.pokedexgruposalinas.home.data.model.response.PokemonAbility
import com.example.pokedexgruposalinas.home.data.model.response.PokemonEvolutionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IApiService {
    @GET("pokemon")
    fun getPokemons(@Query("limit") limit: Int): Call<PokemonApi>

    @GET("pokemon-species/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<PokemonInfo>

    @GET("pokemon/{name}")
    fun getPokemonHabilities(@Path("name") name: String): Call<PokemonAbility>

    @GET("{path}")
    fun getPokemonEvolutions(@Path(value = "path") path: String): Call<PokemonEvolutionResponse>
}