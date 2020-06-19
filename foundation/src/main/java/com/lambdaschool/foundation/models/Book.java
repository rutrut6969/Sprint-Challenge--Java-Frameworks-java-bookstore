package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book extends Auditable{

    //   - `bookid` - long primary key
    //  - `booktitle` - String the title of the book. Cannot be null.
    //  - `ISBN` - String the ISBN number of the book. Cannot be null. Must be unique
    //  - `copy` - Int the year the book was published (copyright date)


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;
    @Column(nullable = false)
    private String booktitle;
    @Column(nullable = false, unique = true)
    private String isbn;

    private int copy;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "sectionid",
            nullable = false)
    @JsonIgnoreProperties(value = "books",
            allowSetters = true)
    private Section section;

    public Book() {}

    public Book(long bookid, String booktitle, String isbn, int copy, @NotNull Section section) {
        this.bookid = bookid;
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.copy = copy;
        this.section = section;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", booktitle='" + booktitle + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copy=" + copy +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
