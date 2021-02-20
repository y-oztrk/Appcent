package com.creative.appcentnasa.`interface`

import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.Photo
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface networkAPI {
    @Headers("Content-Type: application/json")
    @GET("rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY&page=1")
    fun cameralistgetir():Response<ResponseBody>

}