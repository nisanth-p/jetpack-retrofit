package com.neltech.retrofitex.firebase.crudrealtime

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun GetScreen(
    navController: NavHostController,
    sharedViewModel: ShareViewModel
) {
    var phone: String by remember { mutableStateOf("") }
    var name: String by remember { mutableStateOf("") }
    var profession: String by remember { mutableStateOf("") }
    var age: String by remember { mutableStateOf("") }
    var ageInt: Int by remember { mutableStateOf(0) }

    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier.fillMaxSize()) {

        // back button
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
        }

        // get data Layout
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // userID
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    value = phone,
                    onValueChange = {
                        phone = it
                    },
                    label = {
                        Text(text = "Phone Number")
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                // get user data Button
                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(100.dp),
                    onClick = {
                        sharedViewModel.getData(phone, context){
                            name =it.name
                            profession =it.profession
                            age =it.age.toString()
                            ageInt =it.age
                        }
                    }
                ) {
                    Text(text = "Get")
                }
            }
            //UserName
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(
                        text = "Enter User Name"
                    )
                })
            //Proffesion
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = profession,
                onValueChange = { profession = it },
                label = {
                    Text(
                        text = "Enter Proffesion"
                    )
                })
            //Age
            OutlinedTextField(value = age, onValueChange = {
                age = it
                if (age.isNotEmpty()) {
                    ageInt = age.toInt()
                }
            }, label = {
                Text(
                    text = "Enter Your Age"
                )
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            // save Button
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = {
                    val userData = UserData(
                        phone = phone,
                        name = name,
                        profession = profession,
                        age = ageInt
                    )
                    sharedViewModel.saveData(userData = userData, context = context)
                }
            ) {
                Text(text = "Update")
            }
            // delete Button
            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                onClick = {
                     sharedViewModel.deleteData(
                         phoneNumber = phone,
                         context = context,
                         navController = navController
                     )
                }
            ) {
                Text(text = "Delete")
            }
        }
    }
}