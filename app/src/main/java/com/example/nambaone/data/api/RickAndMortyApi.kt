package com.example.nambaone.data.api

import com.example.nambaone.data.model.ResponseModel
import com.example.nambaone.data.model.RickAndMorty
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("/api/character")
    fun getAll(): Deferred<Response<ResponseModel<ArrayList<RickAndMorty>>>>

    @GET("/api/character/{id}")
    fun getById(@Path("id") id: Int): Deferred<Response<RickAndMorty>>
}