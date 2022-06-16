package com.example.gruposalinas.home.data.model.response

import com.google.gson.annotations.SerializedName

data class PokemonApi(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val result: List<Pokemon>
)
