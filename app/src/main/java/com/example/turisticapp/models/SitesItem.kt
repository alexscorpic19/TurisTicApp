package com.example.turisticapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitesItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("points")
    val points: String,
    @SerializedName("linkimage")
    val linkimage: String,
    @SerializedName("detail")
    val detail: String
) : Serializable

