package com.example.nambaone.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nambaone.R
import com.example.nambaone.data.model.RickAndMorty
import com.example.nambaone.databinding.RickAndMortyItemBinding

class RickAndMortyAdapter : RecyclerView.Adapter<RickAndMortyAdapterViewHolder>(){

    var rickAndMorties = ArrayList<RickAndMorty>()
    private lateinit var listener : Listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyAdapterViewHolder {
        val binding : RickAndMortyItemBinding = RickAndMortyItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.rick_and_morty_item, parent, false)
        )
        return RickAndMortyAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RickAndMortyAdapterViewHolder, position: Int) {
        holder.onBind(listener , rickAndMorties[position])
    }

    fun setData(rickAndMorty: ArrayList<RickAndMorty>){
        rickAndMorties.clear()
        rickAndMorties.addAll(rickAndMorty)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = rickAndMorties.size

    fun setListener(listener : Listener){
        this.listener = listener
    }

    interface Listener{
        fun onItemClick(rickAndMorty: RickAndMorty)
    }
}