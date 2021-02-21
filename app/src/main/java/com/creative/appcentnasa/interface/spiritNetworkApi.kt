package com.creative.appcentnasa.`interface`

import com.creative.appcentnasa.model.NasaResponse
import com.creative.appcentnasa.model.NasaResponseSpirit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface spiritNetworkApi {
    @GET("rovers/spirit/photos")
    fun getcameralist(
        @Query("sol") sol: Int,
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Call<NasaResponseSpirit>

}

