package com.finartz.jsfdemo.controller;

import com.finartz.jsfdemo.common.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class UserValidation {
    int newId;
    String newFirstName;
    String newLastName;
    String newPhone;

    public UserValidation() {
    }

    public void nullSelectedUser() {
        newId = 0;
        newFirstName = null;
        newLastName = null;
        newPhone = null;
    }

    public void initSelectedUser(User user) {
        newId = user.getId();
        newFirstName = user.getFirstName();
        newLastName = user.getLastName();
        newPhone = user.getPhone();
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public User getUser() {
        return new User(newId, newFirstName, newLastName, newPhone);
    }
}