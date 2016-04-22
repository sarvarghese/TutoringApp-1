package com.example.roji.tutoring_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewTutorActivity extends AppCompatActivity {
    private String _Name;
    private String _Email;
    private String _Subject;
    private String _Details;

    //setters
    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public void set_Email(String _Email) {
        this._Email = _Email;
    }

    public void set_Subject(String _Subject) {
        this._Subject = _Subject;
    }

    public void set_Details(String _Details) {
        this._Details = _Details;
    }

    public NewTutorActivity() {

    }

    public NewTutorActivity(String Name, String Email, String Subject, String Details) {
        this._Name = Name;
        this._Email = Email;
        this._Subject = Subject;
        this._Details = Details;


    }

    //getters


    public String get_Name() {
        return _Name;
    }

    public String get_Email() {
        return _Email;
    }

    public String get_Subject() {
        return _Subject;
    }

    public String get_Details() {
        return _Details;
    }
}