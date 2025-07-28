package com.maveric.systems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.maveric.systems.controller.UserController;
import com.maveric.systems.service.UserService;
import com.maveric.systems.serviceimpl.UserServiceImpl;

public class UserControllerTest {

    @Test
    public void testGetUserDetails() {
        // Use the real service implementation
        UserService userService = new UserServiceImpl();

        // Inject it manually into the controller
        UserController userController = new UserController(userService);

        // Call the endpoint method
        ResponseEntity<?> response = userController.getUserDetails();

        // Expected output from the real implementation
        List<String> expectedUsers = List.of("Alok", "Ranjan");

        // Assertions
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedUsers, response.getBody());
    }
}
