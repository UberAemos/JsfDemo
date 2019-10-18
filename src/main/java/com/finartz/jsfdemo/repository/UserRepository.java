package com.finartz.jsfdemo.repository;

import com.finartz.jsfdemo.common.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.finartz.jsfdemo.common.script.UserScript.USER_COLUMN_MAPPINGS;

@Repository
public class UserRepository {

    @Autowired
    private Sql2o sql2o;
    private final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    public List<User> getUserList() {
        String queryText = "SELECT * FROM users " +
                "ORDER BY ID";

        List<User> userList;

        try (Connection con = sql2o.open()) {
            logger.info("Connected to db");
            Query query = con.createQuery(queryText);

            userList = query.setColumnMappings(USER_COLUMN_MAPPINGS)
                            .executeAndFetch(User.class);
            logger.info(userList.size() + " users found.");
            return userList;
        } catch (Exception e) {
            logger.error("Error getting user list.", e);
            throw e;
        }
    }

    public void updateUser(User user) {
        String queryText = "UPDATE users " +
                "SET first_name = :first_name," +
                "last_name = :last_name," +
                "phone = :phone " +
                "WHERE ID = :id";
        try (Connection con = sql2o.open()){
            logger.info("Connected to db");
            con.createQuery(queryText)
                    .addParameter("first_name", user.getFirstName())
                    .addParameter("last_name", user.getLastName())
                    .addParameter("phone", user.getPhone())
                    .addParameter("id", user.getId())
                    .executeUpdate();
            logger.info("User is updated");
        } catch (Exception exc) {
            logger.error("Error updating user", exc);
            throw exc;
        }
    }

    public void createUser(User newUser) {
        String queryText = "INSERT INTO users" +
                "(first_name, last_name, phone) " +
                "VALUES(:first_name, :last_name, :phone)";

        try (Connection con = sql2o.open()) {
            logger.info("Connected to db");
            con.createQuery(queryText)
                    .addParameter("first_name", newUser.getFirstName())
                    .addParameter("last_name", newUser.getLastName())
                    .addParameter("phone", newUser.getPhone())
                    .executeUpdate();
            logger.info("User is created");
        } catch (Exception exc) {
            logger.error("Error creating user", exc);
            throw exc;
        }
    }

    public void deleteUser(int id) {
        String queryText = "DELETE FROM users " +
                "WHERE ID = :id";

        try (Connection con = sql2o.open()) {
            logger.info("Connected to db");
            con.createQuery(queryText)
                    .addParameter("id", id)
                    .executeUpdate();

            logger.info("User is deleted");
        } catch (Exception exc) {
            logger.error("Error deleting user", exc);
            throw exc;
        }
    }
}
