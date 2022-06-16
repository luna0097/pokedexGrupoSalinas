package com.example.pokedexgruposalinas.home.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedexgruposalinas.home.data.model.response.PokemonEvolutionResponse
import com.example.pokedexgruposalinas.home.data.service.IApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EvolutionsLineViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: IApiService = retrofit.create(IApiService::class.java)

    val pokemonEvolutions = MutableLiveData<PokemonEvolutionResponse>()

    fun getEvolutions(url: String){
        Log.d("TAG", "getEvolutions: $url")

        CoroutineScope(Dispatchers.IO).launch {
//            val call = service.getPokemonEvolutions(url)
//            Log.d("TAG", "getEvolutions: $call")
//            call.enqueue(object : Callback<PokemonEvolutionResponse> {
//                override fun onResponse(
//                    call: Call<PokemonEvolutionResponse>,
//                    response: Response<PokemonEvolutionResponse>
//                ) {
//                    val data = response.body()?.chain?.species
//                    Log.d("TAG", "onResponse: $data")
//                }
//
//                override fun onFailure(call: Call<PokemonEvolutionResponse>, t: Throwable) {
//                    call.cancel()
//                }
//            })

        }
    }
}