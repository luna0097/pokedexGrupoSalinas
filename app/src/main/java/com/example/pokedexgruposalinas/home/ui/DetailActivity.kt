package com.example.pokedexgruposalinas.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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
        Log.d("TAG", "initUI: entre")
        val pokemonName = intent.extras?.get("name") as String
        Log.d("TAG", "initUI: $pokemonName")
        viewModel.getPokemonInfo(pokemonName)

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