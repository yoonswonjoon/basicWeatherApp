package com.vlm.basicweatherapp.data.weather

import kotlinx.serialization.Serializable

@Serializable
data class WeatherData (

    val list : ListData,

)

@Serializable
data class ListData(
//    val weather : Weather,
    val main : Main
)

@Serializable
data class Weather(
    val main : String,
    val description : String
)

@Serializable
data class Main(
    val temp : String,
    val pressure : String
)