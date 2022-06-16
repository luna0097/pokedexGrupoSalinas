package com.example.pokedexgruposalinas.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexgruposalinas.R
import com.example.pokedexgruposalinas.home.data.model.response.abilityData

class AbilityRvAdapter(): RecyclerView.Adapter<AbilityRvAdapter.AbilityHolder>() {
    private var abilityList: List<abilityData> = emptyList()
    fun setData(list: List<abilityData>){
        abilityList = list
        notifyDataSetChanged()
    }


    class AbilityHolder(view : View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbilityHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AbilityHolder(layoutInflater.inflate(R.layout.ability_item, parent, false))
    }

    override fun onBindViewHolder(holder: AbilityHolder, position: Int) {
        val ability = abilityList[position]

        holder.itemView.findViewById<TextView>(R.id.tvAbility).text = ability.name
    }

    override fun getItemCount(): Int {
        return abilityList.size
    }
}