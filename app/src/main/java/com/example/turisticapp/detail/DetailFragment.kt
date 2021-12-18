package com.example.turisticapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.turisticapp.R

import androidx.navigation.fragment.navArgs
import com.example.turisticapp.databinding.FragmentDetailBinding
import com.example.turisticapp.main.MainActivity

import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private  val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sites = args.sites

        with(detailBinding){
            SitesDetailName.text =sites.name
            SitesDetailDescription.text = sites.description
            SitesDetailComplit.text = sites.detail
            com.squareup.picasso.Picasso.get().load(sites.linkimage).into(SitesDetailImage)

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment())
            }
        }

    }
}