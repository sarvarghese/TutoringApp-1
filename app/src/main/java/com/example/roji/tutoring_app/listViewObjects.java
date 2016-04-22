package com.example.roji.tutoring_app;

/**
 * Created by Saul on 4/21/2016.
 */
public class listViewObjects {
    String name;
    String subject;
    String email;
    int rating;

    public listViewObjects(String name, String subject, String email, int rating)
    {
        this.name=name;
        this.subject=subject;
        this.email=email;
        this.rating=rating;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "listViewObjects{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                '}';
    }
}
