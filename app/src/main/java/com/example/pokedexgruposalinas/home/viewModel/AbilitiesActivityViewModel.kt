package com.example.pokedexgruposalinas.home.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gruposalinas.home.data.model.response.Pokemon
import com.example.pokedexgruposalinas.home.data.model.request.RetrofitHelper
import com.example.pokedexgruposalinas.home.data.model.response.PokemonAbility
import com.example.pokedexgruposalinas.home.data.model.response.ability
import com.example.pokedexgruposalinas.home.data.model.response.abilityData
import com.example.pokedexgruposalinas.home.data.service.IApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AbilitiesActivityViewModel: ViewModel() {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val service: IApiService = retrofit.create(IApiService::class.java)

    var abilitiesList = MutableLiveData<List<abilityData>>()
    val isLoadingAbilities = MutableLiveData<Boolean>()


    fun getHabilities(pokemonName: String){
        CoroutineScope(Dispatchers.IO).launch {
            isLoadingAbilities.postValue(true)
            val call = service.getPokemonHabilities(pokemonName)
            call.enqueue(object : Callback<PokemonAbility>{
                override fun onResponse(
                    call: Call<PokemonAbility>,
                    response: Response<PokemonAbility>
                ) {
                    val abilitiesResponse = response.body()?.abilities?.map {
                        it.ability
                    }

                    if (!abilitiesResponse.isNullOrEmpty()){
                        abilitiesResponse.let { list ->
                            abilitiesList.postValue(list)
                        }
                    }
                    isLoadingAbilities.postValue(false)
                }

                override fun onFailure(call: Call<PokemonAbility>, t: Throwable) {
                    call.cancel()
                    isLoadingAbilities.postValue(false)
                }

            })
        }
    }

}