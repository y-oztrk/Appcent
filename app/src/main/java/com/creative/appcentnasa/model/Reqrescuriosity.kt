package com.creative.appcentnasa.model


import com.google.gson.annotations.SerializedName

data class Reqrescuriosity(
    @SerializedName("photos")
    val camera: Camera,
    val imgSrc:Photo
)