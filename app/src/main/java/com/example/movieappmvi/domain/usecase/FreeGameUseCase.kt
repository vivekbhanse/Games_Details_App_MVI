package com.example.movieappmvi.domain.usecase

import com.example.movieappmvi.domain.repository.FreeGamesRepository
import javax.inject.Inject

class FreeGameUseCase @Inject constructor(private val respository:FreeGamesRepository) {
    operator fun invoke()=respository.getFreeGames()
}