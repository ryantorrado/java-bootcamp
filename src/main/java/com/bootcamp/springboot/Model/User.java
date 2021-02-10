package com.bootcamp.springboot.Model;

public class User {
    private String userCode;
    private String firstName;
    private String lastName;
    private String remarks;

    public User() {

    }

    public User(String userCode, String firstName, String lastName, String remarks) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.remarks = remarks;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
}
