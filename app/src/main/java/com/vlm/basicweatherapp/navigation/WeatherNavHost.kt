package com.vlm.basicweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun WeatherNavHost(
    navController: NavHostController,
    onNavigateToDestination: (NavDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = WeatherDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ){
        weatherGraph(
            toDetailWeather = {
                onNavigateToDestination(
                WeatherDetailDestination, WeatherDetailDestination.createDestination(it)
            ) },
            nestedGraphs = {
                weatherDetailGraph(onBackClick)
            }
        )
        galleryGraph()
    }
}