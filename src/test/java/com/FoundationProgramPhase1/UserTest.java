package com.FoundationProgramPhase1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, String, int, String, String, String, String, String, boolean)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setUserAddress(String)}
     *   <li>{@link User#setUserAge(int)}
     *   <li>{@link User#setUserCity(String)}
     *   <li>{@link User#setUserCounty(String)}
     *   <li>{@link User#setUserEmail(String)}
     *   <li>{@link User#setUserGender(String)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#getName()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getUserAddress()}
     *   <li>{@link User#getUserAge()}
     *   <li>{@link User#getUserCity()}
     *   <li>{@link User#getUserCounty()}
     *   <li>{@link User#getUserEmail()}
     *   <li>{@link User#getUserGender()}
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isGDPR()}
     *   <li>{@link User#toString()}
     * </ul>
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R006 Static initializer failed.
        //   The static initializer of
        //   org.mockito.Mockito
        //   threw java.lang.NoClassDefFoundError while trying to load it.
        //   Make sure the static initializer of Mockito
        //   can be executed without throwing exceptions.
        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
        //       at java.util.ArrayList.forEach(ArrayList.java:1511)

        // Arrange
        // TODO: Populate arranged inputs
        String username = "";
        String password = "";
        String name = "";
        int userAge = 0;
        String userGender = "";
        String userAddress = "";
        String userCity = "";
        String userCounty = "";
        String userEmail = "";
        boolean GDPR = false;

        // Act
        User actualUser = new User(username, password, name, userAge, userGender, userAddress, userCity, userCounty,
                userEmail, GDPR);
        String name2 = "";
        actualUser.setName(name2);
        String password2 = "";
        actualUser.setPassword(password2);
        String userAddress2 = "";
        actualUser.setUserAddress(userAddress2);
        int userAge2 = 0;
        actualUser.setUserAge(userAge2);
        String userCity2 = "";
        actualUser.setUserCity(userCity2);
        String userCounty2 = "";
        actualUser.setUserCounty(userCounty2);
        String userEmail2 = "";
        actualUser.setUserEmail(userEmail2);
        String userGender2 = "";
        actualUser.setUserGender(userGender2);
        String username2 = "";
        actualUser.setUsername(username2);
        String actualName = actualUser.getName();
        String actualPassword = actualUser.getPassword();
        String actualUserAddress = actualUser.getUserAddress();
        int actualUserAge = actualUser.getUserAge();
        String actualUserCity = actualUser.getUserCity();
        String actualUserCounty = actualUser.getUserCounty();
        String actualUserEmail = actualUser.getUserEmail();
        String actualUserGender = actualUser.getUserGender();
        String actualUsername = actualUser.getUsername();
        boolean actualIsGDPRResult = actualUser.isGDPR();
        String actualToStringResult = actualUser.toString();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true), null);
        assertNotEquals(new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true), "Different type to User");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#equals(Object)}
     *   <li>{@link User#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        User user = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true);
        assertEquals(user, user);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#equals(Object)}
     *   <li>{@link User#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        User user = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true);
        User user2 = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true);

        assertEquals(user, user2);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user2.hashCode());
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals4() {
        User user = new User("Username", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true);
        assertNotEquals(user, new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true));
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals5() {
        User user = new User("janedoe", "Password", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true);
        assertNotEquals(user, new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true));
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals6() {
        User user = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "17 High St", "User City", "3",
                "jane.doe@example.org", true);
        assertNotEquals(user, new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true));
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals7() {
        User user = new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "john.smith@example.org", true);
        assertNotEquals(user, new User("janedoe", "iloveyou", "Name", 1, "User Gender", "42 Main St", "User City", "3",
                "jane.doe@example.org", true));
    }
}

