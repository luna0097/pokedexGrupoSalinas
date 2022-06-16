package com.example.gruposalinas.home.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonInfo(
    @SerializedName("base_happiness") val base_happiness: Int,
    @SerializedName("capture_rate") val capture_rate: Int,
    @SerializedName("color") val color: PokemonColor,
    @SerializedName("egg_groups") val egg_groups: List<PokemonEggGroup>,
)

data class PokemonColor(
    @SerializedName("name") val nameColor: String,
    @SerializedName("url") val urlColor: String,
)

data class PokemonEggGroup(
    @SerializedName("name") val nameEggGroup: String,
    @SerializedName("url") val urlEggGroup: String,
)