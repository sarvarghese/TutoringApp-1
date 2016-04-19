package com.example.roji.tutoring_app;


public class TutorsList {
    private String name;
    private String subject;
    private String details;
    private String info;

    public TutorsList(String name, String subject){
        super();
        this.name = name;
        this.subject = subject;
    }
    /**
     public TutorsList(String name, String subject, String details, String info){
     super();
     this.details = details;
     this.info = info;
     }**/

    public String getName() {
        return name;
    }
    public String getSubject() {
        return subject;
    }
    public String getDetails() {
        return details;
    }
    public String getInfo() {
        return info;
    }

}
