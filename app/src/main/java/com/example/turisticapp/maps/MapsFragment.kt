package com.example.turisticapp.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.turisticapp.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val Bmanga = LatLng(7.12539, -73.1198)
        googleMap.addMarker(MarkerOptions().position(Bmanga).title("Bucaramanga"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bmanga, 10F))

        val CatGiron = LatLng(7.0678621529787256, -73.17006689167818)
        googleMap.addMarker(MarkerOptions().position(CatGiron).title("Catedral de Giron"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CatGiron, 10F))

        val ParkSpio = LatLng(7.118693386891463, -73.11038265984669)
        googleMap.addMarker(MarkerOptions().position(ParkSpio).title("Parque Sanpio"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ParkSpio, 10F))

        val CasaBlvar = LatLng(7.1170827951049604, -73.12866474635493)
        googleMap.addMarker(MarkerOptions().position(CasaBlvar).title("Casa de Bolivar"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CasaBlvar, 10F))

        val CerroSt = LatLng(7.081059711953229, -73.07014253101062)
        googleMap.addMarker(MarkerOptions().position(CerroSt).title("Cerro el santisimo"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CerroSt, 10F))

        val panachi = LatLng(6.790339953582724, -73.00354945350466)
        googleMap.addMarker(MarkerOptions().position(panachi).title("PANACHI"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(panachi, 10F))


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}