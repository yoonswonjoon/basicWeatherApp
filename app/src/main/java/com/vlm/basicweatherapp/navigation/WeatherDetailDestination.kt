package com.vlm.basicweatherapp.navigation

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object WeatherDetailDestination : NavDestination  {
    const val detail = "detail"
    override val route: String = "weather_detail_route/{$detail}"
    override val destination: String = "weather_detail_destination"

    fun createDestination(detail : String): String {
        val encodedId = Uri.encode(detail)
        return "weather_detail_route/$encodedId"
    }

}

fun NavGraphBuilder.weatherDetailGraph(
    onBackClick : () -> Unit
){
    composable(
        route = WeatherDetailDestination.route,
        arguments = listOf(
            navArgument(WeatherDetailDestination.detail) { type = NavType.StringType}
        )
    ){
        Column() {
            Text(text = "여기는 디테일")
            Text(text = it.arguments?.getString(WeatherDetailDestination.detail)?: "error")
        }
    }
}