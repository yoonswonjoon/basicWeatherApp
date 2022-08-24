package com.vlm.basicweatherapp.data.weather

import io.ktor.client.*
import io.ktor.client.request.*

class WeatherServiceImpl(
    private val client : HttpClient
) : WeatherService {
    override suspend fun getWeather(): List<WeatherData> {
        return try {
            client.get{
                url(WeatherService.BASE_URL+"/weather?lat=35.153179&lon=129.1186237" + "&" + "appid=${WeatherService.API_KEY}")
            }
        }catch (e:Exception){
            listOf()
        }
    }
}