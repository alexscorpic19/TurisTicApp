package com.example.turisticapp.data

class SitesRepository {
    suspend fun getSites() = ApiFactory.retrofit.getSites()
}