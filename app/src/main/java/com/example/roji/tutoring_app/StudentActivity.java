package com.example.roji.tutoring_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private List<TutorsList> myList = new ArrayList<TutorsList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        populateTutorsList();
        populateListView();
        registerClickCallback();


    }

    private void populateTutorsList(){
        myList.add(new TutorsList("James Bravo", "Math"));
        myList.add(new TutorsList("Julie Smith", "Science"));
        myList.add(new TutorsList("Tommy Mangold", "Enlish"));
        myList.add(new TutorsList("Jay Wright", "Math"));
        myList.add(new TutorsList("Adam Lynch", "Science"));
        myList.add(new TutorsList("Jessica James", "Writing"));
        myList.add(new TutorsList("Jane Alexander", "Math"));
        myList.add(new TutorsList("Mike Epps", "Biology"));

    }

    private void populateListView() {
        ArrayAdapter<TutorsList> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id){

                TutorsList clickedTutor = myList.get(position);
                String message = "You clicked position" + position
                        + "Name: " +clickedTutor.getName();
                Toast.makeText(StudentActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<TutorsList>{
        public MyListAdapter(){
            super(StudentActivity.this, R.layout.item_view, myList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View itemView = convertView;
            if(itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            TutorsList currentTutor = myList.get(position);

            //TutorName
            TextView makeText = (TextView) itemView.findViewById(R.id.item_txtName);
            makeText.setText(currentTutor.getName());

            //Subject
            TextView subjectText = (TextView) itemView.findViewById(R.id.item_txtSubject);
            subjectText.setText(currentTutor.getSubject());

            return itemView;
            //return super.getView(position,convertView,parent);
        }


    }


}
