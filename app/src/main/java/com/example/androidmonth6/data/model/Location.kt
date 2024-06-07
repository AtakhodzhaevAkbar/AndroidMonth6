package com.example.androidmonth6.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)