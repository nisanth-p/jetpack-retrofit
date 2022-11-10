package com.neltech.retrofitex.firebase.crudrealtime

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navController:NavController){

    Column(modifier = Modifier
        .padding(start = 50.dp, end = 50.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        // get user data Button
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(route = Screen.GetScreen.screenRoute)
            }
        ) {
            Text(text = "Get User Data")
        }

        // add user data Button
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(route = Screen.AddScreen.screenRoute)
            }
        ) {
            Text(text = "Add User Data")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){

    MainScreen(rememberNavController())
}