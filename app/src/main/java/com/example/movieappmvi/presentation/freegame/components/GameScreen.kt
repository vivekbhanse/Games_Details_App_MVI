package com.example.movieappmvi.presentation.freegame.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movieappmvi.presentation.freegame.states.FreeGameState

@Composable
fun GameScreen(freeGameState: FreeGameState, modifier: Modifier) {
    if (freeGameState.freeGames?.isNotEmpty()!!) {
        LazyColumn {
            items(freeGameState.freeGames) {
                FreeGamesItem(modifier, it)
            }
        }
    } else if (freeGameState.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}