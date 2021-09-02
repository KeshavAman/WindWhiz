package com.example.windwhiz.Network

import com.example.windwhiz.Model.City
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService:ApiService){
    suspend fun getCityData(city: String, appId:String, units:String):City
    =apiService.getCityData(city,appId,units)
}