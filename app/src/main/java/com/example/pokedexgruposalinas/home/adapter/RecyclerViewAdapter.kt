package com.example.pokedexgruposalinas.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.gruposalinas.home.data.model.response.Pokemon
import com.example.pokedexgruposalinas.R

class RecyclerViewAdapter(val actionClick: (String) -> Unit): RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
    private var pokemonList: List<Pokemon> = emptyList()
    fun setData(list: List<Pokemon>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.pokemon_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val pokemon = pokemonList[position]

        holder.itemView.findViewById<TextView>(R.id.tvPokemonName).text = pokemon.name
        holder.itemView.findViewById<ConstraintLayout>(R.id.pokemonItem).setOnClickListener {
            actionClick(pokemon.name)
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    class Holder(view : View): RecyclerView.ViewHolder(view)
}