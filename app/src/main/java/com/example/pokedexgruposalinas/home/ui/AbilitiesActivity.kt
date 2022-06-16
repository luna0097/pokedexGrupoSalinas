package com.example.pokedexgruposalinas.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.adapter.AbilitiesRvAdapter
import com.example.pokedexgruposalinas.home.viewModel.AbilitiesActivityViewModel

class AbilitiesActivity : AppCompatActivity() {

    lateinit var rvAbilities: RecyclerView
    private lateinit var viewModel: AbilitiesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habilities)

        viewModel = ViewModelProvider(this).get(AbilitiesActivityViewModel::class.java)
        initUI()
    }

    private fun initUI(){
        val pokemonName = intent.extras?.get("name") as String

        rvAbilities = findViewById(R.id.rvAbilities)
        rvAbilities.layoutManager = LinearLayoutManager(this)

        viewModel.getHabilities(pokemonName)
        Log.d("TAG", "initUI: ${viewModel.abilitiesList}")

        viewModel.abilitiesList.observe(this, Observer { list ->
            (rvAbilities.adapter as AbilitiesRvAdapter).setData(list)
        })

    }
}