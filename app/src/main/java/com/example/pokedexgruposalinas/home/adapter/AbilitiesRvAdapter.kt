package com.example.pokedexgruposalinas.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.data.model.response.abilityData

class AbilitiesRvAdapter(): RecyclerView.Adapter<AbilitiesRvAdapter.HolderAbility>() {

    private var abilities: List<abilityData> = emptyList()
    fun setData(list: List<abilityData>){
        Log.d("TAG", "setData: $list")
        abilities = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderAbility {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HolderAbility(layoutInflater.inflate(R.layout.habiliti_item, parent, false))
    }

    override fun onBindViewHolder(holder: HolderAbility, position: Int) {
        val ability = abilities[position]
        holder.itemView.findViewById<TextView>(R.id.tvAbility).text = ability.name
    }

    override fun getItemCount(): Int {
        return abilities.size
    }

    class HolderAbility(view : View): RecyclerView.ViewHolder(view)
}