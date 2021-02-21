package com.creative.appcentnasa.model

import com.google.gson.annotations.SerializedName

data class NasaResponseSpirit(
    @SerializedName("photos")
    val photos: ArrayList<Photo>
)