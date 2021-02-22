package com.creative.appcentnasa.model

import java.io.Serializable

data class NasaResponse (
    val photos: ArrayList<Photo>
) : Serializable