package ua.mainacademy.service;

import ua.mainacademy.dao.UserDAO;
import ua.mainacademy.model.User;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class UserService {

    private static UserDAO userDAO = new UserDAO();

    public static User save(User user) {
        if (nonNull(user.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return userDAO.save(user);
    }

    public static User update(User user) {
        if (isNull(user.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return userDAO.save(user);
    }
}
