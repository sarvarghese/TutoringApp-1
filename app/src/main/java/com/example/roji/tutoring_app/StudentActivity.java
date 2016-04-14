package com.example.roji.tutoring_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final TextView msgStudent = (TextView) findViewById(R.id.tvStudentMsg);

        String msg = "Student view";
        msgStudent.setText(msg);
    }
}
