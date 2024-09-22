package com.example.movieappmvi.domain.repository

import com.example.movieappmvi.core.common.Resource
import com.example.movieappmvi.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow

interface FreeGamesRepository {
    fun getFreeGames():Flow<Resource<List<FreeGames>>>
}