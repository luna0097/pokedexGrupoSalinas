package com.example.pokedexgruposalinas.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.viewModel.EvolutionsLineViewModel

class EvolutionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evolutions)

        Log.d("TAG", "onCreate: HOLI")
//        initUI()
    }
}