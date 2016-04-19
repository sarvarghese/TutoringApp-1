package com.example.roji.tutoring_app;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private filterActivity filter;
    ArrayList<String> listOfSubjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Context context;
        LatLng latlng=null;
        LatLng myLocation=null;
        Location locate;
        mMap = googleMap;
        Bundle n = getIntent().getExtras();
        int distance=n.getInt("distance");
        int i;
        Address address=null;
        listOfSubjects=n.getStringArrayList("subjects");
        Geocoder geocoder= new Geocoder(this);
        double minDist = 1E20; // initialize with a huge value that will be overwritten
        List<Address> addressList=null;
        float[]curDist= new float[1];



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
        {
            mMap.setMyLocationEnabled(true);
        }
        locate=googleMap.getMyLocation();
        myLocation =new LatLng(locate.getLatitude(), locate.getLongitude());
        mMap.addMarker(new MarkerOptions().position(latlng).title("You"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));

        for (i = 0; i < listOfSubjects.size(); i++)
        {
            try
            {
                addressList = geocoder.getFromLocationName(listOfSubjects.get(i),1);

            } catch (IOException e)
            {
                e.printStackTrace();
            }
            address = addressList.get(0);

            latlng= new LatLng(address.getLatitude(), address.getLongitude());
            double lat=address.getLatitude();
            double lon=address.getLongitude();
            Location.distanceBetween(lat, lon, address.getLatitude(), address.getLongitude(), curDist);

            if (curDist[0] < (float)distance)
            {
                mMap.addMarker(new MarkerOptions().position(latlng).title("Name of Tutor"));
            }
        }

    }
/*
    public double getlat(String text)
    {
        //String text="802 South Mills Drive, Euless, Texas, 76040";
        double lat;
        Geocoder geocoder= new Geocoder(this);
        List<Address> addressList=null;
        try {
            addressList = geocoder.getFromLocationName(text,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address= addressList.get(0);
        lat=address.getLatitude();
        //mMap.addMarker(new MarkerOptions().position(latlng).title("802 S Mills Dr,Euless,TX 76040"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        return lat;
    }
    public double getlon(String text)
    {
        double lon;
        //String text="802 South Mills Drive, Euless, Texas, 76040";
        Geocoder geocoder= new Geocoder(this);
        List<Address> addressList=null;
        try {
            addressList = geocoder.getFromLocationName(text,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address= addressList.get(0);
        lon=address.getLongitude();
        //mMap.addMarker(new MarkerOptions().position(latlng).title("802 S Mills Dr,Euless,TX 76040"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        return lon;
    }
    public LatLng search(String text)
    {
        //String text="802 South Mills Drive, Euless, Texas, 76040";
        Geocoder geocoder= new Geocoder(this);
        List<Address> addressList=null;
        try {
            addressList = geocoder.getFromLocationName(text,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address= addressList.get(0);
        LatLng latlng= new LatLng(address.getLatitude(), address.getLongitude());
        //mMap.addMarker(new MarkerOptions().position(latlng).title("802 S Mills Dr,Euless,TX 76040"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        return latlng;
    }
    public LatLng getLocationFromAddress(String strAddress){

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            Address location=address.get(0);
            /*location.getLatitude();
            location.getLongitude();

            p1 = new LatLng((int) (location.getLatitude()),
                    (int) (location.getLongitude()));

            return p1;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return p1;
    }
                */

}
