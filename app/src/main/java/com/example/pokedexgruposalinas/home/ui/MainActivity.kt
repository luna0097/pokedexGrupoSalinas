package com.example.pokedexgruposalinas.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gruposalinas.home.viewModel.MainActivityViewModel
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.adapter.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var rvPokemons: RecyclerView
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        initRecycler()
    }

    fun initRecycler(){
        rvPokemons = findViewById(R.id.rvPokemons)
        rvPokemons.layoutManager = LinearLayoutManager(this)
        rvPokemons.adapter = RecyclerViewAdapter {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it)
            startActivity(intent)
        }

        viewModel.getPokemons()
        viewModel.pokemonList.observe(this, Observer { list ->
            (rvPokemons.adapter as RecyclerViewAdapter).setData(list)
        })

        viewModel.isLoading.observe(this, Observer {
            pbPokemonList.isVisible = it
        })

    }

}