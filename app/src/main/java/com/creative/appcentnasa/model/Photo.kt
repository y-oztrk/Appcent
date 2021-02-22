package com.creative.appcentnasa.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Photo(
    val id: Int,
    val sol: Int,
    val camera: Camera,
    @SerializedName("img_src") val imgSrc: String,
    @SerializedName("earth_date") val earthDate: Date,
    val rover: Rover
) : Serializable