package com.example.nambaone.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nambaone.data.model.RickAndMorty
import com.example.nambaone.databinding.RickAndMortyItemBinding

class RickAndMortyAdapterViewHolder(var binding : RickAndMortyItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun onBind(listener : RickAndMortyAdapter.Listener, rickAndMorty: RickAndMorty){
        itemView.setOnClickListener {
            listener.onItemClick(rickAndMorty)

        }
        Glide.with(itemView.context).load(rickAndMorty.image).into(binding.image)
    }
}