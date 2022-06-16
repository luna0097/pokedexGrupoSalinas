package com.example.pokedexgruposalinas.home.data.model.response

data class PokemonAbility(
    val abilities: List<ability>,
    val base_experience: Int,
)

data class ability(
    val ability: abilityData,
    val is_hidden: String,
    val slot: String,
)

data class abilityData(
    val name: String,
    val url: String,
)
