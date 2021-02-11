package ua.mainacademy.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ua.mainacademy.dao.UserDAO;
import ua.mainacademy.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private static UserService userService;
    private static UserDAO userDAO;

    @BeforeAll
    public static void setData() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO);
    }

    @Test
    void save_SUCCESS() {

        User mockedUser = User.builder()
                .login("ignatenko2207")
                .password("123456")
                .firstName("Alex")
                .lastName("Ignatenko")
                .build();
        mockedUser.setId(1);


        when(userDAO.save(any(User.class))).thenReturn(mockedUser);

        User testUser = userService.save(User.builder()
                .login("ignatenko2207")
                .password("123456")
                .firstName("Alex")
                .lastName("Ignatenko")
                .build());
        assertNotNull(testUser.getId());
        verify(userDAO).save(any(User.class));


    }

    @Test
    void save_WITH_EXCEPTION() {

        User testUser = User.builder()
                .login("ignatenko2207")
                .password("123456")
                .firstName("Alex")
                .lastName("Ignatenko")
                .build();
        testUser.setId(1);

        Assertions.assertThrows(RuntimeException.class, () -> userService.save(testUser));
        verifyZeroInteractions(userDAO);
    }
}