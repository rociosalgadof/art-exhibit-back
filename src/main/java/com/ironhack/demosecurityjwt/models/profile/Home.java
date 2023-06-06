package com.ironhack.demosecurityjwt.models.profile;

import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Home {
    private String subtitle;
    private String homeHeaderBackgroundImg;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Project> listOfProjects;
    private String backstoryBackgroundImg;

    private String gotAProjectBackgroundImg;

    public Home() {
        this.subtitle = "where art meets music";
        this.homeHeaderBackgroundImg = "https://images.unsplash.com/photo-1606821061030-9eedf225857b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1327&q=80";
        Project project1 = new Project("Black & White", "Dive into a collection of Art Works in the grayscale scope", "https://images.unsplash.com/photo-1610528816441-f309483d887a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80");
        Project project2 = new Project("In Living Colors", "Discover a collection of Art Works with color as the main character", "https://images.unsplash.com/photo-1591420699297-88e82958f324?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        this.listOfProjects = List.of(project1, project2);
        this.backstoryBackgroundImg = "https://images.unsplash.com/photo-1571824655925-6ec62810a5c0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80";
        this.gotAProjectBackgroundImg = "https://images.unsplash.com/photo-1598344815973-e4775fc0c6c1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1485&q=80";
    }


    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getHeaderBackgroundImg() {
        return homeHeaderBackgroundImg;
    }

    public void setHeaderBackgroundImg(String headerBackgroundImg) {
        this.homeHeaderBackgroundImg = headerBackgroundImg;
    }

    public List<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(List<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public String getBackstoryBackgroundImg() {
        return backstoryBackgroundImg;
    }

    public void setBackstoryBackgroundImg(String backstoryBackgroundImg) {
        this.backstoryBackgroundImg = backstoryBackgroundImg;
    }

    public String getGotAProjectBackgroundImg() {
        return gotAProjectBackgroundImg;
    }

    public void setGotAProjectBackgroundImg(String gotAProjectBackgroundImg) {
        this.gotAProjectBackgroundImg = gotAProjectBackgroundImg;
    }
}
