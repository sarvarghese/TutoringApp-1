package com.example.roji.tutoring_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class tutorCategoryList extends AppCompatActivity{


    ListView lv;
    int distance;
    ArrayList listOfSubjects= new ArrayList<String>();
    MapsActivity mMap= new MapsActivity();
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
    String subjects[]={"Math","Science","Computer Science","Art","Music","Business","English","Math","Computer Science","English","Art"};
    int ratings[]={4,5,4,4,4,5,4,5,2,4,2};
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

    /*public View onCreateView(Layout inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_tutor_category_list, container,false );
    }*/
    public void onCreate(Bundle savedInstance)
    {
        Bundle n = getIntent().getBundleExtra("n1");
        distance=n.getInt("distance");
        listOfSubjects=n.getStringArrayList("subjects");

        super.onCreate(savedInstance);
        setContentView(R.layout.activity_tutor_category_list);
        lv=(ListView)findViewById(R.id.listView1);
        adapter Adapt = new adapter(this, names,emails, subjects,ratings);
        lv.setAdapter(Adapt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id)
            {
                Toast.makeText(getApplicationContext(), names[pos], Toast.LENGTH_SHORT).show();
            }

        });

        //waiting on how information will be getting however may be figureing out how to do this
        /*
        * we need the tutor registratioVn page created and send info up to data
        * You need to create a databas in filter and pass it via bundle to tutoring categor and mapActivity
        * */
    }
}
