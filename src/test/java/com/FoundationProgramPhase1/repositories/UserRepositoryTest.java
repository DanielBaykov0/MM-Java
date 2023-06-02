package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserRepositoryTest {

    @Test
    void testGetUsers() {
        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", false);
        List<User> actualUsers = UserRepository.getUsers();
        Assertions.assertTrue(actualUsers.contains(user));
        Assertions.assertEquals(5, actualUsers.size());
    }
}
