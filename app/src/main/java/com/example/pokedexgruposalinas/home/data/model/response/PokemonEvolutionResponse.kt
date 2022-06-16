package com.example.pokedexgruposalinas.home.data.model.response

import com.example.gruposalinas.home.data.model.response.PokemonColor
import com.google.gson.annotations.SerializedName

data class PokemonEvolutionResponse(
    @SerializedName("chain") val chain: chain,
    @SerializedName("id") val id: Int,
)

data class chain(
    @SerializedName("evolves_to") val evolves_to: List<evolvesTo>,
    @SerializedName("is_baby") val is_baby: Boolean,
    @SerializedName("species") val species: species,
)


data class evolvesTo(
    @SerializedName("evolves_to") val evolves_to: List<evolvesTo>,
    @SerializedName("is_baby") val is_baby: Boolean,
    @SerializedName("species") val species: species,
)

data class species(
    @SerializedName("name") val name: String
)