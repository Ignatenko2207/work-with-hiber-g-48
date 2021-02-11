package ua.mainacademy.controller;

import lombok.RequiredArgsConstructor;
import ua.mainacademy.model.User;
import ua.mainacademy.service.UserService;

@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public User save(User user) {
        return userService.save(user);
    }

}
