package com.example.movieappmvi.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FreeGameDto(
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String,
    val game_url: String,
    val genre: String,
    val id: Int,
    val platform: String,
    val publisher: String,
    val release_date: String,
    val short_description: String,
    val thumbnail: String,
    val title: String
)