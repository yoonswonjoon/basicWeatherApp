package com.vlm.basicweatherapp.navigation

import android.graphics.drawable.Icon

data class MainDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon?,
    val unselectedIcon: Icon?,
    val iconTextId: String
    ) : NavDestination