package com.javaacademy.learning.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//este util sa punem si proprietatea name, la @entity, cand vrem sa construim querry-uri si in acele sa facem referinta catre acea tabela/entitate
@Entity(name = "user")
@Table(name = "user", schema = "publc")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "user")
    private List<Book> books = new ArrayList<Book>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_APPLICATION", schema = "public",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "application_id", nullable = false))
    private List<Application> applications = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setUser(this);
    }
    public void addApplication(Application application) {
        this.applications.add(application);
        application.addUser(this);
    }
}
