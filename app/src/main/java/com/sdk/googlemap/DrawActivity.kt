package com.sdk.googlemap

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.sdk.googlemap.databinding.ActivityDrawBinding

class DrawActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnPolylineClickListener,
    GoogleMap.OnPolygonClickListener {
    private lateinit var map: GoogleMap
    private val binding by lazy { ActivityDrawBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        createPolyline()
        createPolygon()

        map.setOnPolylineClickListener(this)
        map.setOnPolygonClickListener(this)
    }

    private fun createPolygon() {
        map.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(-27.457, 153.040),
                    LatLng(-33.852, 151.211),
                    LatLng(-37.813, 144.962),
                    LatLng(-34.928, 138.599)
                )
        )
    }

    private fun createPolyline() {
        val options = PolylineOptions()
        options.apply {
            color(Color.BLACK)
            width(10f)
            clickable(true)
            add(
                LatLng(-35.016, 143.321),
                LatLng(-34.747, 145.592),
                LatLng(-34.364, 147.891),
                LatLng(-33.501, 150.217),
                LatLng(-32.306, 149.248),
                LatLng(-32.491, 147.309)
            )
        }
        map.addPolyline(options)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))
    }

    override fun onPolylineClick(p0: Polyline) {

    }

    override fun onPolygonClick(p0: Polygon) {

    }
}