package com.cirta.software.model;

import com.cirta.software.annotation.Column;
import com.cirta.software.annotation.PrimaryKey;


public class Person {
    @PrimaryKey
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;

    public Person() {
    }

    public Person(Long id , String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
