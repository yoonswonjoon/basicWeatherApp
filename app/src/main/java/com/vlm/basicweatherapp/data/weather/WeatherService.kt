package com.vlm.basicweatherapp.data.weather

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json

interface WeatherService {
    companion object{
        const val API_KEY = "57fbab649f27e081cc95ccde89013b2e"
        const val BASE_URL = "https://api.openweathermap.org/data/2.5"
        fun create() : WeatherService {
            return WeatherServiceImpl(
                HttpClient(Android){
                    install(Logging){
                        level = LogLevel.ALL
                        logger = Logger.DEFAULT
                    }
                    install(HttpTimeout){
                        requestTimeoutMillis = 10_000L
                        connectTimeoutMillis = 10_000L
                        socketTimeoutMillis = 10_000L
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer(
                            kotlinx.serialization.json.Json {
                                ignoreUnknownKeys = true // 모델에 없고, json에 있는경우 해당 key 무시
                                prettyPrint = true
                                isLenient = true // "" 따옴표 잘못된건 무시하고 처리
                                encodeDefaults = true //null 인 값도 json에 포함 시킨다.
                            }
                        )
                    }
                }
            )
        }
    }
    suspend fun getWeather() : List<WeatherData>

}

