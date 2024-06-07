package com.example.androidmonth6.api

import com.example.androidmonth6.data.model.BaseResponce
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): BaseResponce
}
//2