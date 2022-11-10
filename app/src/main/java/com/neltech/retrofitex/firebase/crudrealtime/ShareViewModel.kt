package com.neltech.retrofitex.firebase.crudrealtime

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ShareViewModel :ViewModel(){

    fun saveData( userData:UserData, context: Context) = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore.collection("Employees").document(userData.phone)
        try {
            fireStoreRef.set(userData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully saved data", Toast.LENGTH_SHORT).show()
                }
        }catch (e:Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
    fun getData(phoneNumber:String,context: Context,data:(UserData)->Unit) = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore.collection("Employees").document(phoneNumber)
        try {
            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists())
                    {
                        val user =it.toObject<UserData>()
                        if (user != null) {
                            data(user)
                        }
                        Toast.makeText(context, "Successfully Retrived data"+user, Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "Something went wrong"+it, Toast.LENGTH_SHORT).show()
                    }
                }

        }catch (e:Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
    fun deleteData(phoneNumber:String,context: Context,navController: NavController) = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore.collection("Employees").document(phoneNumber)
        try {
            fireStoreRef.delete()
                .addOnSuccessListener {

                    Toast.makeText(context, "Successfully Deleted data", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }

        }catch (e:Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

    }
}