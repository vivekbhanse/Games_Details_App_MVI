package com.example.movieappmvi.data.remote.mapper

import com.example.movieappmvi.data.remote.dto.FreeGameDto
import com.example.movieappmvi.domain.model.FreeGames

fun FreeGameDto.toDomainFreeGames(): FreeGames {
    return FreeGames(thumbnail, title, id, short_description, game_url)
}