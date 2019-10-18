package com.finartz.jsfdemo.controller;

import com.finartz.jsfdemo.common.model.User;
import com.finartz.jsfdemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import java.util.List;

@ManagedBean(value="userManagement")
@Scope("view")
public class UserManagement {

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserManagement.class);

    private List<User> users;

    private int newId;
    private String newFirstName, newLastName, newPhone;

    public UserManagement() {
    }

    @PostConstruct
    public void init() {
        users = userRepository.getUserList();
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

    public void updateUser() {
        logger.info("Updating user");
        User user = new User(newId, newFirstName, newLastName, newPhone);
        userRepository.updateUser(user);
        users = userRepository.getUserList();
        nullSelectedUser();
    }

    public void createUser() {
        logger.info("Creating user");
        User user = new User(0, newFirstName, newLastName, newPhone);
        userRepository.createUser(user);
        users = userRepository.getUserList();
        nullSelectedUser();
    }

    public void deleteUser() {
        logger.info("Deleting user");
        userRepository.deleteUser(newId);
        users = userRepository.getUserList();
        nullSelectedUser();
    }

    // Getters and setters

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
}