package com.example.movieappmvi.presentation.freegame.states

sealed class UiEffect {
    class ShowSnackBar(val msg:String):UiEffect()
    object NavigateToDetailScreen:UiEffect()
}