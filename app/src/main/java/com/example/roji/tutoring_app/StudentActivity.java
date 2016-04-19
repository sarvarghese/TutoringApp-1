package com.example.roji.tutoring_app;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final TextView msgStudent = (TextView) findViewById(R.id.tvStudentMsg);


        String msg = "Student view";
        msgStudent.setText(msg);
    }

    public void goToFilter(View v) {

        Intent intent = new Intent(v.getContext(), filterActivity.class);
        startActivityForResult(intent, 0);
    }


}
