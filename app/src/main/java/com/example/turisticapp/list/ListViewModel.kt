package com.example.turisticapp.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.turisticapp.models.Sites
import com.example.turisticapp.models.SitesItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel(){

    private var sitesLoad : MutableLiveData<ArrayList<SitesItem>> = MutableLiveData()
    val onSitesLoaded: LiveData<ArrayList<SitesItem>> = sitesLoad

    fun loadMockSitesFromJson(sitesString: InputStream?) {
        val sitesString = sitesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitesLoad.value = gson.fromJson(sitesString, Sites::class.java)
    }

}