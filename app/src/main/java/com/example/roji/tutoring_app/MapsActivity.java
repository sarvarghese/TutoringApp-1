package com.example.roji.tutoring_app;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
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
    public static ArrayList filterdObjects = new ArrayList<listViewObjects>();
    String emails[]={"sg.gutierrez95@gmail.com",
            "jMan@hotmail.com",
            "sarahGirl95@yahoo.com",
            "ukraineHero@gmail.com",
            "jacoba@yahoo.com",
            "lislisalisa@gmail.com",
            "WendyMarvel@yahoo.com",
            "daviddoes@hotmail.com",
            "kswiss@yahoo.com",
            "rickMartin@gmail.com","dareApp@hotmail.com"};
    String subjects[]={"Math","Science","Computer Science","Art","Music","Business","English","Math","Computer Science","English","Art"};

    int ratings[]={4,5,4,4,4,5,4,5,2,4,2};
    String names[]={"Saul","Jibin","Sarah","Shervin","Jacob","Lisa","Wendy","David","John","Kevin","Rick"};
    String addresses[]={"802 South Mills Drive, Euless, Texas 76040",
            "1505 Woodvine Drive, Euless, Texas 76040 ",
            "1810 Branch Hollow lane, Grapevine, Texas 76051",
            "2925 Kimball Court, Grapevine, Texas 76051",
            "1678 Golden Pond Drive, Cedar Hill, Texas 75104",
            "900 Clover Hill Lane, Cedar Hill 75104",
            "1213 Crown Drive, Mansfield, Texas 76063",
            "705 Colby Drive, Mansfield, Texas 76063",
            "3109 Hurstview Drive, Hurst, Texas 76054",
            "7613 Palomar Drive, North Richland Hills, Texas, 76180",
            "4209 Monna Street, Haltom City, Texas 76117"};
     String Subjects[]= {"Math","Science","Computer Science","Art","Music","Business","English","Math","Computer Science","English","Art"};
     ArrayList listOfSubjects = new ArrayList<String>();

    private GoogleMap mMap;
    private filterActivity filter;
    Location locate;
    LatLng myLocal;
    int distance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       // setUpMapIfNeeded();
        Bundle n = getIntent().getBundleExtra("n1");
         distance=n.getInt("distance");
        listOfSubjects=n.getStringArrayList("subjects");


    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Context context;
        LatLng latlng=null;
        //LatLng myLocation=null;
        Location locate;
        mMap = googleMap;

        int i;
        Address address=null;

        Geocoder geocoder= new Geocoder(this);
        double minDist = 1E20; // initialize with a huge value that will be overwritten
        List<Address> addressList=null;
        //float[]curDist= new float[1];
        double distDiff=0;
        double lat;
        double lon;

        int k=0;
        myLocal=(LatLng)search("802 South Mills Drive, Euless, Texas 76040");
        mMap.addMarker(new MarkerOptions().position(myLocal).title("You"));
        for (i = 0; i < listOfSubjects.size(); i++)
        {


            //latlng= new LatLng(address.getLatitude(), address.getLongitude());
            for(int j=0; j<Subjects.length;j++)
            {
                try
                {
                    addressList = geocoder.getFromLocationName(addresses[j],1);

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                address = addressList.get(0);

//&& Subjects[i].equalsIgnoreCase((String)listOfSubjects.get(j)
                latlng= new LatLng(address.getLatitude(), address.getLongitude());
                //latlng=search(addresses[j]);
                distDiff=getDistance(myLocal,latlng)/1609.344;
                //Toast.makeText(getApplicationContext(), String.valueOf(distDiff), Toast.LENGTH_SHORT).show();
                //Location.distanceBetween(myLocal.latitude, myLocal.longitude, latlng.latitude, latlng.longitude, curDist);
                if ((distDiff <= (double)distance) && Subjects[j].equalsIgnoreCase((String)listOfSubjects.get(i)) )
                {
                    //listViewObjects account = new listViewObjects(names[j],subjects[j],emails[j], ratings[j]);
                   // filterdObjects.add(account);
                    Toast.makeText(getApplicationContext(), names[j], Toast.LENGTH_SHORT).show();
                    mMap.addMarker(new MarkerOptions().position(latlng).title(addresses[j]));
                }

            }

            //double lat=address.getLatitude();
            //double lon=address.getLongitude();



        }

    }
    public Boolean checkConstraints(String tutorAddress, String subjectFilter, String tutorSubject )
    {
        Context context;
        LatLng latlng=null;
        Location locate;
        int i;
        Address address=null;
        Geocoder geocoder= new Geocoder(this);
        List<Address> addressList=null;
        double distDiff=0;
        double lat;
        double lon;
        int k=0;
        myLocal=(LatLng)search("802 South Mills Drive, Euless, Texas 76040");


                try
                {
                    addressList = geocoder.getFromLocationName(tutorAddress,1);

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                address = addressList.get(0);
                latlng= new LatLng(address.getLatitude(), address.getLongitude());
                distDiff=getDistance(myLocal,latlng)/1609.344;
                if ((distDiff <= (double)distance) && tutorSubject.equalsIgnoreCase(subjectFilter) )
                {
                    return true;
                }


        return false;
    }
    public double getDistance(LatLng LatLng1, LatLng LatLng2) {
        double distance = 0;
        Location begin = new Location("A");
        begin.setLatitude(LatLng1.latitude);
        begin.setLongitude(LatLng1.longitude);

        Location end = new Location("B");
        end.setLatitude(LatLng2.latitude);
        end.setLongitude(LatLng2.longitude);

        distance = begin.distanceTo(end);
        return distance;

    }
    public boolean findMatchSubject(int i, int j)
    {

        if(Subjects[i].equalsIgnoreCase((String)listOfSubjects.get(j)))
            return true;
        else
            return false;

    }
    public LatLng search(String text)
    {
        //String text="802 South Mills Drive, Euless, Texas, 76040";
        Geocoder geocoder= new Geocoder(this);
        List<Address> addressList=null;
        if(text !=null || text.equalsIgnoreCase(""))
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
    /*if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
        {
            mMap.setMyLocationEnabled(true);
        }


        Geocoder geocoderer;
        String bestProvider;
        List<Address> user = null;
        double late;
        double lnge;

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        bestProvider = lm.getBestProvider(criteria, false);
        Location location = lm.getLastKnownLocation(bestProvider);

        if (location == null){
            Toast.makeText(getApplicationContext(),"Location Not found", Toast.LENGTH_LONG).show();
        }else{
            geocoderer = new Geocoder(getApplicationContext());
            try {
                user = geocoderer.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                late=(double)user.get(0).getLatitude();
                lnge=(double)user.get(0).getLongitude();
                System.out.println(" DDD lat: " +late+",  longitude: "+lnge);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }


        double longitude = location.getLongitude();
        double latitude = location.getLatitude();




        myLocation =new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("You"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));*/

/* private final Context context;
    boolean isGPSEnabled = false;
    boolean isNetworkEnbaled = false;
    boolean canGetLocation=false;

    double latitude;
    double longitude;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000*60*1;

    protected LocationManager localmanager;
    public MapsActivity(Context context)
    {
        this.context=context;
        getLocation();

    }
    public Location getLocation()
    {
        try
        {
            localmanager= (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled=localmanager.isProviderEnabled(Location.GPS_PROVIDER);
        }
        catch
        {}
    }

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
