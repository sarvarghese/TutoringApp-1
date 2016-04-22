package com.example.roji.tutoring_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;


public class TutorActivity extends AppCompatActivity implements View.OnClickListener {

    //MyDBHandler dbHandler;
    TextView mytext;
    Button bSave;
    EditText name;
    User usr;

    private static Firebase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        name = (EditText) findViewById(R.id.Name);
        bSave = (Button) findViewById(R.id.saveInfo);

        Firebase.setAndroidContext(this);

        bSave.setOnClickListener(this);

        Intent intent = getIntent();
        usr = (User)intent.getExtras().getSerializable("user");

    }

    @Override
    public void onClick(View v) {
        NewTutorActivity tutor = new NewTutorActivity();
        tutor.set_Name(name.getText().toString());

        Database database  = new Database();
        database.putTutor(usr, tutor);
        Toast.makeText(TutorActivity.this,"Tutor Added", Toast.LENGTH_SHORT).show();


    }
}