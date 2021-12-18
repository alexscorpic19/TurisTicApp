package com.example.turisticapp.data

import com.example.turisticapp.models.Sites
import retrofit2.http.GET

interface ApiService {
    @GET("alexscorpic19/TurisTicApp/Sites")
    suspend fun getSites(): Sites
}