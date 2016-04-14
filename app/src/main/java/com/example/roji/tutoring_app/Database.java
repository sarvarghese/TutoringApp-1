package com.example.roji.tutoring_app;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.FirebaseException;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;


/**
 * Created by Sarah on 4/9/16.
 */
public class Database {

        private static Firebase database;
        private static final String url = "https://tutoring.firebaseio.com/";
        private static final String userpath="users";
        private User user;

        public Database()
        {
            if(database==null) {
                database = new Firebase(url);
            }else System.out.println("already created!");
            System.out.println("hello");
        }

        public Database(Firebase database) {
            setDatabase(database);
        }


        public Firebase getDatabase() {

            return database;
        }

        public void setDatabase(Firebase database) {
            this.database = database;
        }

        @Override
        public String toString() {
            return url;
        }

        public User getUser(User usr) {
            user = usr;

            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {
                        User temp = dataSnapshot.child(userpath).child(user.getEmail()).getValue(User.class);
                        if (temp == null) throw new FirebaseException("Hello");
                        user.setPassword(temp.getPassword());
                        user.setEmail(temp.getEmail());
                        //user.setName(temp.getName());
                    } catch (FirebaseException ex) {
                        System.out.println("User doesn't exist!");
                    }

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.err.println("Cancelled!");
                }
            });

            return user;

        }

        public void putUser(User usr)
        {


            database.child(userpath).child(usr.getEmail()).setValue(usr, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    System.out.println("PUT USER IN DATADASE");
                }
            });
        }


        public int authUser(String email, String pass) {
            System.out.println(email);
            System.out.println(pass);
            database.authWithPassword(email, pass, new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    System.out.println("Logged IN!");
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    System.err.println("Failed to Login!");

                }

            });
            System.out.println(database.getAuth());
            if(database.getAuth() == null)return 0;
            else return 1;
        }

        public void createAccount(String email,String pass)
        {
            database.createUser(email, pass, new Firebase.ResultHandler() {
                @Override
                public void onSuccess() {
                    System.out.println("Created user account!");
                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    System.err.println("User's acount was not created!");
                }
            });
        }




}
