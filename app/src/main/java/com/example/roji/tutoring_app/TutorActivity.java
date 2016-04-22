package com.example.roji.tutoring_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;




public class TutorActivity extends AppCompatActivity {

    //MyDBHandler dbHandler;
    TextView mytext;
    EditText myInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);
    }
}