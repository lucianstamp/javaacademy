package com.javaacademy.learning.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<BookDTO> books = new ArrayList<>();
    private List<ApplicationDTO> applications = new ArrayList<ApplicationDTO>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public List<ApplicationDTO> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationDTO> applications) {
        this.applications = applications;
    }
}
