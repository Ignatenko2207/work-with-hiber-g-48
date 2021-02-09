package ua.mainacademy.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {

    private static User user;
    private static Order order;

    @BeforeAll
    public static void setUp() {
        UserDAO userDAO = new UserDAO();
        user = userDAO.save(User.builder()
                .login("testLogin")
                .password("testPass")
                .firstName("Alex")
                .lastName("Ignatenko")
                .build());
    }

    @Test
    void save() {
        OrderDAO orderDAO = new OrderDAO();
        order = orderDAO.save(Order.builder()
                .creationTime(new Date().getTime())
                .status(Order.Status.OPEN)
                .user(user)
                .build());

        assertNotNull(order);
        assertNotNull(order.getId());
    }

    @AfterAll
    public static void tearUp() {
        UserDAO userDAO = new UserDAO();
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.delete(order);
        userDAO.delete(user);
    }

}