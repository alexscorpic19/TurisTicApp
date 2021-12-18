package com.example.turisticapp.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var listViewModel: ListViewModel
    private lateinit var sitesAdapter: SitesAdapter
    private var listSites: ArrayList<SitesItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        listViewModel.loadMockSitesFromJson(context?.assets?.open("Sites_list.json"))
        listViewModel.onSitesLoaded.observe(viewLifecycleOwner, { result ->
            onSitesLoadedSubscribe(result)
        })

        sitesAdapter = SitesAdapter(listSites, onItemClicked = { onSitesClicked(it) } )

        listBinding.list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitesAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSitesLoadedSubscribe(result: ArrayList<SitesItem>?) {
        result?.let { listSites ->
            sitesAdapter.appendItems(listSites)
            /*
            // TODO: revisar feedback
            this.listSuperheroes = listSuperheroes
            superHeroesAdapter.notifyDataSetChanged()
            */
        }
    }

    private fun onSitesClicked(sites: SitesItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sites = sites))
    }


}