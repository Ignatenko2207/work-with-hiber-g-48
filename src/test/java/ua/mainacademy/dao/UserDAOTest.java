package ua.mainacademy.dao;

import org.junit.jupiter.api.Test;
import ua.mainacademy.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void save() {
        User user = User.builder()
                .login("ignatenko2207")
                .password("123456")
                .firstName("Alex")
                .lastName("Ignatenko")
                .build();
        User savedUser = new UserDAO().save(user);
        assertNotNull(savedUser.getId());
    }

    @Test
    void findById() {
        User user = User.builder()
                .login("ignatenko2207")
                .password("123456")
                .firstName("Alex")
                .lastName("Ignatenko")
                .build();
        UserDAO userDAO = new UserDAO();
        User savedUser = userDAO.save(user);
        assertNotNull(savedUser.getId());

        User foundUser = userDAO.findById(savedUser.getId());
        assertNotNull(foundUser);
        System.out.println(foundUser);
    }

}