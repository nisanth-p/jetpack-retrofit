package com.neltech.retrofitex.rerofix

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiResponse {
    @POST("user")
    fun postData(@Body reqModel: ReqDataModel):Call<DataModel?>
}