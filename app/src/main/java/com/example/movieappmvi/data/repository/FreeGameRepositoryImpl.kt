package com.example.movieappmvi.data.repository

import com.example.movieappmvi.core.common.Resource
import com.example.movieappmvi.data.remote.FreeGameAPI
import com.example.movieappmvi.data.remote.mapper.toDomainFreeGames
import com.example.movieappmvi.domain.model.FreeGames
import com.example.movieappmvi.domain.repository.FreeGamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FreeGameRepositoryImpl @Inject constructor(private val freeGameAPI: FreeGameAPI):FreeGamesRepository {
    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow {
        emit(Resource.Loading())
        try {
            val result=freeGameAPI.getFreeGames().map {
                it.toDomainFreeGames()
            }
            emit(Resource.Success(result))
        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}