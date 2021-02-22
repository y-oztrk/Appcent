package com.creative.appcentnasa.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rover(
    val id: Int,
    @SerializedName("landing_date") val landingDate: String,
    @SerializedName("launch_date") val launchDate: String,
    val name: String,
    val status: String
) : Serializable