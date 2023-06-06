package com.ironhack.demosecurityjwt.models.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.ResultSet;
import java.util.List;

@Embeddable
public class About {
    private String aboutHeaderBackgroundImg;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Paragraph> description;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Project> middleSection;

    private String linkedIn;
    private String contactInfoBackgroundImg;

    public About() {
        this.aboutHeaderBackgroundImg = "https://images.unsplash.com/photo-1506863530036-1efeddceb993?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1044&q=80";
        Paragraph paragraph1 = new Paragraph("Germaine is an Architectural Designer and Travel Enthusiast who likes to pay attention to the details.");
        Paragraph paragraph2 = new Paragraph("Her interests in Architecture and Travel mainly stemmed from the enjoyment of learning new information about the World and experiencing different environments and cultures around the World.");
        Paragraph paragraph3 = new Paragraph("She graduated from National University of Singapore in 2018 with a Masters of Architecture and Bachelor of Arts in Architecture (Honours). In 2014, she graduated from Singapore Polytechnic with a Diploma in Architecture.");
        this.description = List.of(paragraph1, paragraph2, paragraph3);
        Project project1 = new Project("The Origin", "Germainedays was initially created in 2016 as a blog to document her 4 Month long Student Exchange life in Munich, Germany. However, she realized that there was a lot of travel information she wanted to share and a diary blog wasn't suitable for it. This gave rise to expansion and the creation of a proper travel guide platform.");
        Project project2 = new Project("Integrating with Architecture", "With an Architecture background of 7 years, Germaine figured she might as well share some Architecture Materials. Thus, an integrated platform was formed.");
        this.middleSection = List.of(project1, project2);
        this.linkedIn = "https://www.linkedin.com/";
        this.contactInfoBackgroundImg = "https://images.unsplash.com/photo-1571824655925-6ec62810a5c0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80";
    }

    public String getHeaderBackgroundImg() {
        return aboutHeaderBackgroundImg;
    }

    public void setHeaderBackgroundImg(String headerBackgroundImg) {
        this.aboutHeaderBackgroundImg = headerBackgroundImg;
    }

    public List<Paragraph> getDescription() {
        return description;
    }

    public void setDescription(List<Paragraph> description) {
        this.description = description;
    }

    public List<Project> getMiddleSection() {
        return middleSection;
    }

    public void setMiddleSection(List<Project> middleSection) {
        this.middleSection = middleSection;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getContactInfoBackgroundImg() {
        return contactInfoBackgroundImg;
    }

    public void setContactInfoBackgroundImg(String contactInfoBackgroundImg) {
        this.contactInfoBackgroundImg = contactInfoBackgroundImg;
    }

}
