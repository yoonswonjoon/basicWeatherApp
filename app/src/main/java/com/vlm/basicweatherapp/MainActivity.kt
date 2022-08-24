package com.vlm.basicweatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.vlm.basicweatherapp.data.weather.WeatherService
import com.vlm.basicweatherapp.navigation.WeatherApp
import com.vlm.basicweatherapp.ui.theme.BasicWeatherAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherServiceImpl = WeatherService.create()
        this.lifecycleScope.launch(Dispatchers.IO){
            val date = weatherServiceImpl.getWeather()
            val a = 0
        }
        setContent {
            BasicWeatherAppTheme {
                WeatherApp()
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }
}
fun check(
    end : ()->Unit
){

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicWeatherAppTheme {
        Greeting("Android")
    }
}