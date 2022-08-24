package com.vlm.basicweatherapp.navigation

import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object GalleryDestination : NavDestination {
    override val route: String = "gallery_route"
    override val destination: String = "gallery_destination"
}

fun NavGraphBuilder.galleryGraph(){
    composable(
        route = GalleryDestination.route
    ){
        Text("gallery")
    }
}