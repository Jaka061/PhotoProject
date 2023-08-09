package com.example.nambaone.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseModel<T>(
    @SerializedName("info") var info: Info? = null,
    @SerializedName("results") var results: T? = null
)

data class Info(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("pages") var pages: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("prev") var prev: String? = null
)

data class RickAndMorty(
    @SerializedName("id") var id: Int? = null,
    @PrimaryKey(true)
    @SerializedName("name") var name: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("species") var species: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("origin") var origin: Origin? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("location") var location: Location? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("episode") var episode: ArrayList<String> = arrayListOf(),
    @SerializedName("url") var url: String? = null,
    @SerializedName("created") var created: String? = null
) : Serializable

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("url")val url: String
) : Serializable

data class Origin(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
) : Serializable