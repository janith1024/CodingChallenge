package com.jsa.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by Janith on 8/27/2017.
 * This is the entity class for the student There can be many details can be related to student
 * I consider only following attributes only
 */
public class Student extends Entity {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
