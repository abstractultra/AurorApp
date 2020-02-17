package com.aurora.jaguars

import android.content.ContentValues.TAG
import android.content.Context
import android.location.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import com.aurora.jaguars.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_view)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}

/*
private class MyLocationListener : LocationListener {
    override fun onLocationChanged(loc: Location) {
        editLocation.setText("")
        pb.setVisibility(View.INVISIBLE)
        Toast.makeText(
            getBaseContext(),
            "Location changed: Lat: " + loc.getLatitude().toString() + " Lng: "
                    + loc.getLongitude(), Toast.LENGTH_SHORT).show()
        val longitude = "Longitude: " + loc.getLongitude()
        Log.v(TAG, longitude)
        val latitude = "Latitude: " + loc.getLatitude()
        Log.v(TAG, latitude)
        /*------- To get city name from coordinates -------- */
        var cityName: String? = null
        val gcd = Geocoder(getBaseContext(), Locale.getDefault())
        val addresses: List<Address>
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                loc.getLongitude(), 1)
            if (addresses.size > 0) {
                System.out.println(addresses[0].getLocality())
                cityName = addresses[0].getLocality()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val s = (longitude + "\n" + latitude + "\n\nMy Current City is: "
                + cityName)
        editLocation.setText(s)
    }

    override fun onProviderDisabled(provider: String) {}
    override fun onProviderEnabled(provider: String) {}
    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
}
*/