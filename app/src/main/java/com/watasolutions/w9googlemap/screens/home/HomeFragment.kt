package com.watasolutions.w9googlemap.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.watasolutions.w9googlemap.R
import com.watasolutions.w9googlemap.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    lateinit var binding: FragmentHomeBinding
    lateinit var vm: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        // Add a marker in KHTN and move the camera - 10.762913,106.6821717,15z
        val khtnUniversityLocation = LatLng(10.762913, 106.6821717)
        mMap!!.addMarker(
            MarkerOptions()
                .position(khtnUniversityLocation)
                .title("Marker in KHTN")
        )
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(khtnUniversityLocation))
    }
}