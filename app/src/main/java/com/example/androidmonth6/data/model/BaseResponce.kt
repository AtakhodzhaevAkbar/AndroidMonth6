package com.example.androidmonth6.data.model


import com.google.gson.annotations.SerializedName

data class BaseResponce(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)