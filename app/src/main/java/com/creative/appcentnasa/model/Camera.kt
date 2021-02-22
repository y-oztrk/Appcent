package com.creative.appcentnasa.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Camera(
    val id: String,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("rover_id") val roverİd: Int
) : Serializable