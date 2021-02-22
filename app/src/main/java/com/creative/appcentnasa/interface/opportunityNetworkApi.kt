package com.creative.appcentnasa.`interface`

import com.creative.appcentnasa.model.NasaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface opportunityNetworkApi {
    @GET("rovers/opportunity/photos")
    fun oppogetcameralist(
        @Query("sol") sol: Int,
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Call<NasaResponse>

}