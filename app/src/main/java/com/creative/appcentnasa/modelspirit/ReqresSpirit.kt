package com.creative.appcentnasa.modelspirit


import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.Photo
import com.google.gson.annotations.SerializedName


data class ReqresSpirit(
    @SerializedName("photos")
    val camera: Camera,
    val imgSrc: Photo
)