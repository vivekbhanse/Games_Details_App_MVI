package com.example.movieappmvi.di

import com.example.movieappmvi.data.remote.FreeGameAPI
import com.example.movieappmvi.data.repository.FreeGameRepositoryImpl
import com.example.movieappmvi.domain.repository.FreeGamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(com.example.movieappmvi.core.utils.Constants.BASE_URL)
        .build()


    @Provides
    @Singleton
    fun provideFreeGameAPi(retrofit: Retrofit) : FreeGameAPI = retrofit.create(FreeGameAPI::class.java)


    @Provides
    @Singleton
    fun provideFreeGameRepository(freeGameAPI: FreeGameAPI):FreeGamesRepository{
        return FreeGameRepositoryImpl(freeGameAPI)
    }

}