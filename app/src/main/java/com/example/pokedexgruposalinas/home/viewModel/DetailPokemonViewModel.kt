package com.example.gruposalinas.home.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gruposalinas.home.data.model.response.PokemonInfo
import com.example.pokedexgruposalinas.home.data.service.IApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailPokemonViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: IApiService = retrofit.create(IApiService::class.java)

    val pokemonInfo = MutableLiveData<PokemonInfo>()

    fun getPokemonInfo(name: String){
        Log.d("TAG", "getPokemonInfo: $name")
        CoroutineScope(Dispatchers.IO).launch {
            val call = service.getPokemonByName(name)
            call.enqueue(object : Callback<PokemonInfo> {
                override fun onResponse(call: Call<PokemonInfo>, response: Response<PokemonInfo>) {
                    response.body()?.let { pokemon ->
                        pokemonInfo.postValue(pokemon)
                        Log.d("TAG", "onResponse: $pokemon")
                    }
                }

                override fun onFailure(call: Call<PokemonInfo>, t: Throwable) {
                    call.cancel()
                }

            })
        }
    }
}