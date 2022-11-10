package com.neltech.retrofitex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.neltech.retrofitex.firebase.crudrealtime.NavGraph
import com.neltech.retrofitex.firebase.crudrealtime.ShareViewModel
import com.neltech.retrofitex.firebase.google.LoginScreen
import com.neltech.retrofitex.ui.theme.RetrofitExTheme

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    private lateinit var navController: NavHostController
    private val sharedViewModel: ShareViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitExTheme {

                // RetroSamples()
               // LoginScreen()
                navController = rememberNavController()
                NavGraph(navController,sharedViewModel)
            }

        }
    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetrofitExTheme {
        Greeting("Android")
    }
}