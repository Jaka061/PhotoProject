package com.example.nambaone.data.repo

import com.example.nambaone.data.api.RickAndMortyApi
import com.example.nambaone.data.model.RickAndMorty
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickiAndMortyRepository @Inject constructor(var rickAndMortyApi : RickAndMortyApi) {

    suspend fun getAll() : ArrayList<RickAndMorty>{
        val response = rickAndMortyApi.getAll().await()
        if (response.isSuccessful) {
            return response.body()?.results ?: throw error("Characters not found")
        } else {
            throw error("Error loading data")
        }
    }

    suspend fun getById(id: Int): RickAndMorty {
        val response = rickAndMortyApi.getById(id).await()

        if (response.isSuccessful) {
            return response.body() ?: throw error("Character not found")
        } else {
            throw error("Error loading data")
        }
    }
}