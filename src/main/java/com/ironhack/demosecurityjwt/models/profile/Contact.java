package com.ironhack.demosecurityjwt.models.profile;

import jakarta.persistence.*;

@Embeddable
public class Contact {
    private String backgroundImage;

    public Contact() {
        this.backgroundImage = "https://images.unsplash.com/photo-1444065707204-12decac917e8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1473&q=80";
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
