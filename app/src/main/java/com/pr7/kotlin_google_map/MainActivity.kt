package com.pr7.kotlin_google_map

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions



class MainActivity : AppCompatActivity(),OnMapReadyCallback  {

    //41.3207  60.3730
    lateinit var googleMap: GoogleMap
    val arrayList=ArrayList<LatLng>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( com.pr7.kotlin_google_map.R.layout.activity_main)

        arrayList.add(LatLng(41.3207, 60.3830))
        arrayList.add(LatLng(41.3307, 60.3930))
        arrayList.add(LatLng(41.3407, 60.4030))
        arrayList.add(LatLng(41.3507, 60.4130))
        arrayList.add(LatLng(41.3607, 60.4230))


        val mapFragment = supportFragmentManager
            .findFragmentById( com.pr7.kotlin_google_map.R.id.googlemap) as SupportMapFragment
        mapFragment.getMapAsync(this)



    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap=p0

        var defaultlocation=LatLng(41.3207, 60.3830)
        for (i in 0 until arrayList.size){
//            var khiva = i
//            var markerOptions = MarkerOptions()
//                .position(khiva)
//                .title("Khiva")
//            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.qizil2))
//            googleMap.addMarker(markerOptions)
//


            val marker: Marker = googleMap.addMarker(
                MarkerOptions()
                    .position(LatLng(arrayList.get(i).latitude,arrayList.get(i).longitude))
                    .title("Your title")
            )!!





            googleMap.setOnMarkerClickListener {
                if (it.position==arrayList.get(2)){
                    Toast.makeText(this@MainActivity,"$it",Toast.LENGTH_SHORT).show()

                }


                true
            }
        }






        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultlocation, 10f))
    }
}