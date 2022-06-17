package com.example.pokedexgruposalinas.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedexgruposalinas.home.data.model.request.RetrofitHelper
import com.example.pokedexgruposalinas.home.data.model.response.PokemonEvolutionResponse
import com.example.pokedexgruposalinas.home.data.model.response.species
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


    private val retrofit = RetrofitHelper.getRetrofit()
    private val service: IApiService = retrofit.create(IApiService::class.java)
    val evolutions = MutableLiveData<List<species>>()
    private var species = mutableListOf<species>()

    val isLoadingEvolutions = MutableLiveData<Boolean>()

    fun getEvolutions(url: String){
        val path = url.substring(25)

        CoroutineScope(Dispatchers.IO).launch {
            isLoadingEvolutions.postValue(true)
            val call = service.getPokemonEvolutions(path)
            call.enqueue(object : Callback<PokemonEvolutionResponse> {
                override fun onResponse(
                    call: Call<PokemonEvolutionResponse>,
                    response: Response<PokemonEvolutionResponse>
                ) {
                    response.body()?.chain?.species?.let { species.add(it) }
                    response.body()?.chain?.evolves_to?.forEach {
                        species.add(it.species)
                        it.evolves_to.forEach {
                            species.add(it.species)
                        }
                    }
                    evolutions.postValue(species)
                    isLoadingEvolutions.postValue(false)
                }

                override fun onFailure(call: Call<PokemonEvolutionResponse>, t: Throwable) {
                    call.cancel()
                    isLoadingEvolutions.postValue(false)
                }
            })
        }

    }
}