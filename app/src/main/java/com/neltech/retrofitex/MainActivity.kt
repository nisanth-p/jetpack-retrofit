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
import com.neltech.retrofitex.ui.theme.RetrofitExTheme
import com.neltech.retrofitex.ui.theme.greenColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    //output
    val name = mutableStateOf("")
    val id = mutableStateOf("")
    val create = mutableStateOf("")
    val job = mutableStateOf("")
    //input
    val nameInput = mutableStateOf("")
    val jobInput = mutableStateOf("")
    val data = ReqDataModel("", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitExTheme {


                // on below line we are specifying background color for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    // on the below line we are specifying the theme as the scaffold.
                    Scaffold(
                        // in scaffold we are specifying top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(backgroundColor = greenColor,

                                // along with that we are specifying title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(
                                        // on below line we are specifying text to display in top app bar.
                                        text = "Retrofit POST Request in Android",

                                        // on below line we are specifying modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on the below line we are calling the pop window dialog method to display ui.
                        postData()
                    }
                }


            }

        }
    }

    @Composable
    fun postData() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(text = name.value)
            Text(text = job.value)
            Text(text = id.value)
            Text(text = create.value)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = nameInput.value, onValueChange = {
                nameInput.value = it
            }, label = {
                Text(text ="Name")
            })
            TextField(value = jobInput.value, onValueChange = {
                jobInput.value = it
            },label = {
                Text(text ="Job")
            })
            Button(onClick = {
                data.name =nameInput.value
                data.job =jobInput.value
                postDataUsingRetrofit()
            }) {
                Text(text ="Register")
            }

        }
    }

    fun postDataUsingRetrofit() {

        val apiUrl: String = "https://reqres.in/api/"
        val retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiResponse: ApiResponse = retrofit.create(ApiResponse::class.java)
        val res: Call<DataModel?> = apiResponse.postData(data)
        res.enqueue(object : Callback<DataModel?> {
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                val dataModel: DataModel? = response.body()
                if (dataModel != null) {
                    name.value = dataModel.name
                    job.value = dataModel.job
                    id.value = dataModel.id
                    create.value = dataModel.createdAt
                    Log.d(TAG, "onResponse:name = " + dataModel.name)
                    Log.d(TAG, "onResponse: job =" + dataModel.job)
                    Log.d(TAG, "onResponse: id =" + dataModel.id)
                    Log.d(TAG, "onResponse:createdAt = " + dataModel.createdAt)
                }
            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }


        })

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