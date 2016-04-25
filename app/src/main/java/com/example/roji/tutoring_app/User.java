package com.example.roji.tutoring_app;


import android.provider.ContactsContract;
import java.io.Serializable;

/**
 * Created by Sarah on 4/9/16.
 */
public class User implements Serializable{
    private String email;
    private String password;
    private String username;

    public User() {
    }

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
