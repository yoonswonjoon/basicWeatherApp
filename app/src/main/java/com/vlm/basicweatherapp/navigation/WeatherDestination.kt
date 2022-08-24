package com.vlm.basicweatherapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vlm.basicweatherapp.data.MockedData

object WeatherDestination: NavDestination {
    override val route: String = "weather_route"
    override val destination: String = "weather_destination"
}

fun NavGraphBuilder.weatherGraph(
    toDetailWeather : (String)-> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
){
    navigation(
        route = WeatherDestination.route,
        startDestination = WeatherDestination.destination
    ){
        composable(
            route = WeatherDestination.destination
        ){

            //여기에 컴포저블 화면 구현
            val mocked = remember {
                MockedData().list
            }
            Column() {
                mocked.forEach {
                    Button(onClick = { toDetailWeather(it) }) {
                        Text(text = it)
                    }
                }
                Text("weather")
            }

        }
        nestedGraphs()
    }
}