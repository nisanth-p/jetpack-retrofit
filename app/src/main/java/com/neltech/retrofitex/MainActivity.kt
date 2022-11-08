package com.neltech.retrofitex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neltech.retrofitex.firebase.google.LoginScreen
import com.neltech.retrofitex.rerofix.ApiResponse
import com.neltech.retrofitex.rerofix.DataModel
import com.neltech.retrofitex.rerofix.ReqDataModel
import com.neltech.retrofitex.rerofix.RetroSamples
import com.neltech.retrofitex.ui.theme.RetrofitExTheme
import com.neltech.retrofitex.ui.theme.greenColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitExTheme {

               // RetroSamples()
                LoginScreen()


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