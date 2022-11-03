package com.neltech.retrofitex

data class DataModel(val name:String,val job:String,val id:String,val createdAt:String)
{


    fun response(){
        val res:String ="{\n" +
                "    \"name\": \"morpheus4\",\n" +
                "    \"job\": \"leader\",\n" +
                "    \"id\": \"859\",\n" +
                "    \"createdAt\": \"2022-11-03T04:04:58.163Z\"\n" +
                "}"
    }
}

