package com.example.pokedexgruposalinas.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gruposalinas.home.viewModel.DetailPokemonViewModel
import com.example.pokedexgruposalinas.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel = ViewModelProvider(this).get(DetailPokemonViewModel::class.java)

        initUI()

    }

    private fun initUI(){
        val pokemonName = intent.extras?.get("name") as String
        viewModel.getPokemonInfo(pokemonName)


        val intentEvolutions = Intent(this, EvolutionsActivity::class.java)
        val intentHabilities = Intent(this, AbilitiesActivity::class.java)
        intentHabilities.putExtra("name", pokemonName)

        btnEvolutions.setOnClickListener {
            startActivity(intentEvolutions)
        }

        btnHabilities.setOnClickListener {
            startActivity(intentHabilities)
        }


        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            val eggs = pokemon.egg_groups.map { it.nameEggGroup }
            txtName.text = pokemonName
            txtFelicidad.text = "${pokemon.base_happiness}"
            txtCaptura.text = "${pokemon.capture_rate}"
            txtColor.text = pokemon.color.nameColor
            txtEggs.text = "$eggs"
        })
    }
}