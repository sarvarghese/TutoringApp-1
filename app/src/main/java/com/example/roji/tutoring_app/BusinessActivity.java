package com.example.roji.tutoring_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BusinessActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        final TextView msgBusiness = (TextView) findViewById(R.id.tvBusinessMsg);

        String msg = "Business view";
        msgBusiness.setText(msg);
    }
}

