package com.creative.appcentnasa.model

import com.google.gson.annotations.SerializedName

data class NasaResponse (
    @SerializedName("photos")
    val photos: ArrayList<Photo>
)