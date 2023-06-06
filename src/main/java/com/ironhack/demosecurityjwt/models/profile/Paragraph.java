package com.ironhack.demosecurityjwt.models.profile;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition="LONGTEXT")
    private String text;

    public Paragraph(){}

    public Paragraph(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
