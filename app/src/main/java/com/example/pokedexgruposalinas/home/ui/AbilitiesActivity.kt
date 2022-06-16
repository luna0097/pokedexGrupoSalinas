package com.example.pokedexgruposalinas.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.adapter.AbilityRvAdapter
import com.example.pokedexgruposalinas.home.adapter.RecyclerViewAdapter
import com.example.pokedexgruposalinas.home.viewModel.AbilitiesActivityViewModel
import kotlinx.android.synthetic.main.activity_habilities.*

class AbilitiesActivity : AppCompatActivity() {

    private lateinit var rvAbilities: RecyclerView
    private lateinit var viewModel: AbilitiesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habilities)

        viewModel = ViewModelProvider(this).get(AbilitiesActivityViewModel::class.java)
        initUI()
    }

    private fun initUI(){
        rvAbilities = findViewById(R.id.rvAbilities)
        rvAbilities.layoutManager = LinearLayoutManager(this)
        rvAbilities.adapter = AbilityRvAdapter()
        val pokemonName = intent.extras?.get("name") as String

        viewModel.getHabilities(pokemonName)
        Log.d("TAG", "initUI: ${viewModel.abilitiesList}")

        viewModel.abilitiesList.observe(this, Observer { list ->
            (rvAbilities.adapter as AbilityRvAdapter).setData(list)
        })

    }
}