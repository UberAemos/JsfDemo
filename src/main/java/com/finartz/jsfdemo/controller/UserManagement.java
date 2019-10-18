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
    private UserValidation userValidation;

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserManagement.class);

    private List<User> users;

    public UserManagement() {
    }

    @PostConstruct
    public void init() {
        users = userRepository.getUserList();
    }

    public void nullSelectedUser() {
        userValidation.nullSelectedUser();
    }

    public void initSelectedUser(User user) {
        userValidation.initSelectedUser(user);
    }

    public void updateUser() {
        logger.info("Updating user");
        User user = userValidation.getUser();
        userRepository.updateUser(user);
        users = userRepository.getUserList();
        userValidation.nullSelectedUser();
    }

    public void createUser() {
        logger.info("Creating user");
        User user = new User(0, userValidation.getNewFirstName(), userValidation.getNewLastName(), userValidation.getNewPhone());
        userRepository.createUser(user);
        users = userRepository.getUserList();
        userValidation.nullSelectedUser();
    }

    public void deleteUser() {
        logger.info("Deleting user");
        userRepository.deleteUser(userValidation.getNewId());
        users = userRepository.getUserList();
        userValidation.nullSelectedUser();
    }

    // Getters and setters

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getNewId() {
        return userValidation.getNewId();
    }

    public void setNewId(int newId) {
        userValidation.setNewId(newId);
    }

    public String getNewFirstName() {
        return userValidation.getNewFirstName();
    }

    public void setNewFirstName(String newFirstName) {
        userValidation.setNewFirstName(newFirstName);
    }

    public String getNewLastName() {
        return userValidation.getNewLastName();
    }

    public void setNewLastName(String newLastName) {
        userValidation.setNewLastName(newLastName);
    }

    public String getNewPhone() {
        return userValidation.getNewPhone();
    }

    public void setNewPhone(String newPhone) {
        userValidation.setNewPhone(newPhone);
    }
}