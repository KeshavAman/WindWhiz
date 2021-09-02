package com.example.windwhiz.Repository

import com.example.windwhiz.Model.City
import com.example.windwhiz.Network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiServiceImp: ApiServiceImp) {

    fun getCityData(city:String) = flow {
        val response= apiServiceImp.getCityData(city,"90ff69f437192858f8b407c906a041ac","metric")
        emit(response)
    }.flowOn(Dispatchers.IO)
        .conflate()
}
