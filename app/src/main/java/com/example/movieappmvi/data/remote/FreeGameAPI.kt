package com.example.movieappmvi.data.remote

import com.example.movieappmvi.data.remote.dto.FreeGameDto
import retrofit2.http.GET

interface FreeGameAPI {

    @GET("games")
    suspend fun getFreeGames() : List<FreeGameDto>
}