package com.example.gruposalinas.home.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gruposalinas.home.data.model.response.Pokemon
import com.example.gruposalinas.home.data.model.response.PokemonApi
import com.example.pokedexgruposalinas.home.data.service.IApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel: ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: IApiService = retrofit.create(IApiService::class.java)

    val pokemonList = MutableLiveData<List<Pokemon>>()

    fun getPokemons(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = service.getPokemons(151)
            call.enqueue(object : Callback<PokemonApi> {
                override fun onResponse(call: Call<PokemonApi>, response: Response<PokemonApi>) {
                    response.body()?.result?.let { list ->
                        pokemonList.postValue(list)
                    }
                }

                override fun onFailure(call: Call<PokemonApi>, t: Throwable) {
                    call.cancel()
                }

            })
        }
    }
}