package com.lambdaschool.foundation.models;


import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable{
    // - [ ] authors
    //  - `authorid` - long primary key
    //  - `lastname` - String last name of the author
    //  - `firstname` - String first name of the author

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;
    private String firstname;

    public Author() {
    }

    public Author(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
