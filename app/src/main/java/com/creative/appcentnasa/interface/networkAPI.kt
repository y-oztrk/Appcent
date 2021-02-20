package com.creative.appcentnasa.`interface`

import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.NasaResponse
import com.creative.appcentnasa.model.Photo
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface networkAPI {

    @GET("rovers/curiosity/photos")
    fun cameralistgetir(
        @Query("sol") sol: Int,
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Call<NasaResponse>

}