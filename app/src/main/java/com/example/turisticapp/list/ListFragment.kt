package com.example.turisticapp.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.turisticapp.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turisticapp.databinding.FragmentListBinding
import com.example.turisticapp.main.MainActivity
import com.example.turisticapp.models.Sites
import com.example.turisticapp.models.SitesItem

import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var sitesAdapter: SitesAdapter
    private lateinit var listSites: ArrayList<SitesItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        listSites = loadMockSitesFromJson()
        sitesAdapter = SitesAdapter(listSites, onItemClicked = { onSitesClicked(it) } )

        listBinding.list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitesAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSitesClicked(sites: SitesItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sites = sites))
    }

    private fun loadMockSitesFromJson(): ArrayList<SitesItem> {
        val sitesString: String = context?.assets?.open("Sites_list.json")?.bufferedReader().use { it!!.readText() } //TODO reparar !!
        val gson = Gson()
        val sitesList = gson.fromJson(sitesString, Sites::class.java)
        return sitesList
    }
}