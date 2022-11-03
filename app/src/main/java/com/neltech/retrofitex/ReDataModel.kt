package com.neltech.retrofitex

data class ReqDataModel(var name:String, var job:String){
    fun request(){
        val req:String ="{\n" +
                "    \"name\": \"morpheus4\",\n" +
                "    \"job\": \"leader\"\n" +
                "}"
    }
}
