package com.ironhack.demosecurityjwt.models.profile;

import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Gallery {
    private String headerBackgroundImg;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> listOfImages;
    private String footerImage;

    public Gallery() {
        this.headerBackgroundImg = "https://images.unsplash.com/photo-1506863530036-1efeddceb993?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1044&q=80";
        Image img1 = new Image("https://images.unsplash.com/photo-1614103812210-e468413c3dba?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80");
        Image img2 = new Image("https://images.unsplash.com/photo-1648148860152-acbdc5018e6e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80");
        Image img3 = new Image("https://images.unsplash.com/photo-1589402353576-3b540e60fa1b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1471&q=80");
        this.listOfImages= List.of(img1, img2,img3);
        this.footerImage = "https://images.unsplash.com/photo-1571824655925-6ec62810a5c0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80";
    }

    public String getHeaderBackgroundImg() {
        return headerBackgroundImg;
    }

    public void setHeaderBackgroundImg(String headerBackgroundImg) {
        this.headerBackgroundImg = headerBackgroundImg;
    }

    public List<Image> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(List<Image> listOfImages) {
        this.listOfImages = listOfImages;
    }

    public String getFooterImage() {
        return footerImage;
    }

    public void setFooterImage(String footerImage) {
        this.footerImage = footerImage;
    }
}
