package com.vlm.basicweatherapp.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WeatherApp(
    appState: WeatherAppState = rememberWeatherAppState()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            WeatherBottomBar(
                destinations = appState.mainDestinations,
                onNavigateToDestination = appState::navigate,
                currentDestination = appState.currentDestination
            )
        }) {
        WeatherNavHost(
            navController = appState.navController,
            onNavigateToDestination = appState::navigate,
            onBackClick = appState::onBackClick
        )
    }
}


@Composable
fun WeatherBottomBar(
    destinations: List<MainDestination>,
    onNavigateToDestination: (MainDestination) -> Unit,
    currentDestination: NavDestination?
){
    BottomNavigation(){
        destinations.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            BottomNavigationItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                       Text(text = destination.route)
//                    val icon = if (selected) {
//                        destination.selectedIcon
//                    } else {
//                        destination.unselectedIcon
//                    }
//                    when (icon) {
//                        is ImageVectorIcon -> Icon(
//                            imageVector = icon.imageVector,
//                            contentDescription = null
//                        )
//                        is DrawableResourceIcon -> Icon(
//                            painter = painterResource(id = icon.id),
//                            contentDescription = null
//                        )
//                    }
                },
                label = { destination.iconTextId }
            )
        }
    }

}