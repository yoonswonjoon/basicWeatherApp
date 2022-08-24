package com.vlm.basicweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberWeatherAppState(
    navHostController: NavHostController = rememberNavController()
)
:WeatherAppState{
    return remember(navHostController){
        WeatherAppState(navHostController)
    }
}

class WeatherAppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val mainDestinations: List<MainDestination> = listOf(
        MainDestination(
            route = WeatherDestination.route,
            destination = WeatherDestination.destination,
            selectedIcon = null,
            unselectedIcon = null,
            iconTextId = "weather"
        ),
        MainDestination(
            route = GalleryDestination.route,
            destination = GalleryDestination.destination,
            selectedIcon = null,
            unselectedIcon = null,
            iconTextId = "gallery"
        ),
    )

    fun navigate(destination: com.vlm.basicweatherapp.navigation.NavDestination, route: String? = null) {

            if (destination is MainDestination) {
                navController.navigate(route ?: destination.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            } else {
                navController.navigate(route ?: destination.route)
            }
        }

    fun onBackClick() {
        navController.popBackStack()
    }
}