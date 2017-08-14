package com.example.admin.myfireap;

/**
 * Created by Admin on 8/3/2017.
 */

public class Tours {

    String head;
    String description;
    String photoUrl;



    public Tours(String head, String description,String photoUrl) {
        this.head = head;
        this.description = description;
        this.photoUrl=photoUrl;
    }

    public Tours() {
    }


    public String getPhotoUrl(){return photoUrl;}

    public String getHead(){return head;}

    public String getDescription(){return description;}

    public Tours(String head, String description){
        this.head= head;
        this.description=description;
    }
}
