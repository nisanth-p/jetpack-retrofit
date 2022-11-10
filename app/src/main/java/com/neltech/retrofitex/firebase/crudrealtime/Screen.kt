package com.neltech.retrofitex.firebase.crudrealtime

sealed class Screen(val screenRoute:String) {
    object MainScreen:Screen("Main")
    object AddScreen:Screen("Add")
    object GetScreen:Screen("Get")
}