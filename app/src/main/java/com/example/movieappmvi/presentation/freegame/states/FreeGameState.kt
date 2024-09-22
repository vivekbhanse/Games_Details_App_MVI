package com.example.movieappmvi.presentation.freegame.states

import com.example.movieappmvi.domain.model.FreeGames

data class FreeGameState (
    val freeGames:List<FreeGames>? = emptyList(),
    val errorMsg:String="",
    val isLoading:Boolean=false
)