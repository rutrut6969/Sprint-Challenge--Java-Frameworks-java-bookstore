package com.lambdaschool.foundation.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false, unique = true)
    private String sectionname;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "section",
            allowSetters = true)
    List<Book> books = new ArrayList<>();

    public Section() {
    }

    public Section(String sectionname){
        this.sectionname = sectionname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionid=" + sectionid +
                ", sectionname='" + sectionname + '\'' +
                '}';
    }
}
