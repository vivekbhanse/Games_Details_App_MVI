package com.example.movieappmvi.presentation.navigation.screens

import okhttp3.Route

sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
}