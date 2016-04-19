package com.example.roji.tutoring_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.FirebaseException;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin, bRegister;
    RadioButton rbStudent, rbTutor, rbBusiness;
    EditText etEmail, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        rbStudent = (RadioButton) findViewById(R.id.rbStudent);
        rbTutor = (RadioButton) findViewById(R.id.rbTutor);
        rbBusiness = (RadioButton) findViewById(R.id.rbBusiness);


        bLogin = (Button) findViewById(R.id.bLogin);
        bRegister = (Button) findViewById(R.id.bRegister);

        Firebase.setAndroidContext(this);

        bLogin.setOnClickListener(this);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

    }


    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:
                Firebase ref = new Firebase("https://tutoring.firebaseio.com");
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(rbStudent.isChecked()){
                    ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(AuthData authData) {
                            System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                            Intent studentI = new Intent(LoginActivity.this, StudentActivity.class);
                            LoginActivity.this.startActivity(studentI);
                            finish();
                        }
                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    });

                }


                else if(rbTutor.isChecked()){
                    ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(AuthData authData) {
                            System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                            Intent TutorIntent = new Intent(LoginActivity.this, TutorActivity.class);
                            LoginActivity.this.startActivity(TutorIntent);
                            finish();
                        }
                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


                else if(rbBusiness.isChecked()){
                ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                        Intent BusinessIntent = new Intent(LoginActivity.this, BusinessActivity.class);
                        LoginActivity.this.startActivity(BusinessIntent);
                        finish();
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                });
        }
                break;
            default:
                break;

        }

    }

}


