package com.FoundationProgramPhase1;

import java.util.Objects;

public class User {

    private final String username;
    private final String password;
    private final String name;
    private final int userAge;
    private final String userGender;
    private final String userAddress;
    private final String userCity;
    private final String userCounty;
    private final String userEmail;

    public User(String username, String password, String name, int userAge, String userGender, String userAddress, String userCity, String userCounty, String userEmail) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userCounty = userCounty;
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getUserCounty() {
        return userCounty;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(userAddress, user.userAddress) && Objects.equals(userEmail, user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, userAddress, userEmail);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + name + '\'' +
                ", userAge=" + userAge +
                ", userGender='" + userGender + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userCounty='" + userCounty + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
