package com.example.turisticapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.turisticapp.data.SitesRepository
import com.example.turisticapp.models.Sites
import com.example.turisticapp.models.SitesItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitesLoad : MutableLiveData<ArrayList<SitesItem>> = MutableLiveData()
    val onSitesLoaded: LiveData<ArrayList<SitesItem>> = sitesLoad

    private val repository = SitesRepository()

    fun getSitesFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            sitesLoad.postValue(repository.getSites())
        }
    }

    fun loadMockSitesFromJson(sitesString: InputStream?) {
        val sitesString = sitesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitesLoad.value = gson.fromJson(sitesString, Sites::class.java)
    }
}