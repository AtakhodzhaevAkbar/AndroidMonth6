package com.example.androidmonth6.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any
)