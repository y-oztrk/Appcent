package com.creative.appcentnasa.model


import com.google.gson.annotations.SerializedName

data class Reqrescuriosity(
    @SerializedName("photos")
    val photos: List<Photo>
)