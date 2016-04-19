package com.example.roji.tutoring_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.FirebaseException;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etEmail, etPassword;

    RadioButton rbRStudent, rbRTutor, rbRBusiness;

    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        rbRStudent = (RadioButton) findViewById(R.id.rbRStudent);
        rbRTutor = (RadioButton) findViewById(R.id.rbRTutor);
        rbRBusiness = (RadioButton) findViewById(R.id.rbRBusiness);

        bRegister = (Button) findViewById(R.id.bRegister);

        Firebase.setAndroidContext(this);

        bRegister.setOnClickListener(this);

    }



    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bRegister:
                Firebase ref = new Firebase("https://tutoring.firebaseio.com");
                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString();

                if(rbRStudent.isChecked()){
                    ref.createUser(Email, Password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {
                            System.out.println("Successfully created user account with uid: " + result.get("uid"));
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent StudentIntent = new Intent(RegisterActivity.this, StudentActivity.class);
                            RegisterActivity.this.startActivity(StudentIntent);
                            finish();
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                else if(rbRTutor.isChecked()){
                    ref.createUser(Email, Password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {
                            System.out.println("Successfully created user account with uid: " + result.get("uid"));
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent TutorIntent = new Intent(RegisterActivity.this, TutorActivity.class);
                            RegisterActivity.this.startActivity(TutorIntent);
                            finish();
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if(rbRBusiness.isChecked()){
                    ref.createUser(Email, Password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {
                            System.out.println("Successfully created user account with uid: " + result.get("uid"));
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent BusinessIntent = new Intent(RegisterActivity.this, BusinessActivity.class);
                            RegisterActivity.this.startActivity(BusinessIntent);
                            finish();
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


                break;
            default:
                break;
        }

    }


}

