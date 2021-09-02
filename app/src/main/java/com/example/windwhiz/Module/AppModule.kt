package com.example.windwhiz.Module

import com.example.windwhiz.Network.ApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseurl():String= "https://api.openweathermap.org/data/2.5/"

    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseUrl:String):Retrofit =
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesApiService(retrofit: Retrofit):ApiService=
        retrofit.create(ApiService::class.java)
}