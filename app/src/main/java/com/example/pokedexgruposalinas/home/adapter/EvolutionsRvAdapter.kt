package com.example.pokedexgruposalinas.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.data.model.response.species

class EvolutionsRvAdapter: RecyclerView.Adapter<EvolutionsRvAdapter.EvolutionsHolder>() {
    private var evolutionList: List<species> = emptyList()
    fun setData(list: List<species>){
        evolutionList = list
        notifyDataSetChanged()
    }


    class EvolutionsHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EvolutionsHolder(layoutInflater.inflate(R.layout.evolution_item, parent, false))
    }

    override fun onBindViewHolder(holder: EvolutionsHolder, position: Int) {
        val evolution = evolutionList[position]
        holder.itemView.findViewById<Button>(R.id.btnEvolution).text = evolution.name
    }

    override fun getItemCount(): Int {
        return evolutionList.size
    }
}