package com.ironhack.demosecurityjwt.models.profile;

import com.ironhack.demosecurityjwt.models.user.User;
import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Home home;
    @Embedded
    private Contact contact;
    @Embedded
    private About about;
    @Embedded
    private Gallery gallery;

    private String owner;


    public Profile() {
        this.home = new Home();
        this.contact = new Contact();
        this.about = new About();
        this.gallery = new Gallery();
    }
    public Profile(String owner) {
        this.owner = owner;
        this.home = new Home();
        this.contact = new Contact();
        this.about = new About();
        this.gallery = new Gallery();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}
