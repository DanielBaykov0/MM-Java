package com.FoundationProgramPhase1;

import java.util.Objects;

public class User {

    private String username;
    private String password;
    private String name;
    private int userAge;
    private String userGender;
    private String userAddress;
    private String userCity;
    private String userCounty;
    private String userEmail;
    private final boolean GDPR;

    public User(String username, String password, String name, int userAge, String userGender, String userAddress, String userCity, String userCounty, String userEmail, boolean GDPR) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userCounty = userCounty;
        this.userEmail = userEmail;
        this.GDPR = GDPR;
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

    public boolean isGDPR() {
        return GDPR;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserCounty(String userCounty) {
        this.userCounty = userCounty;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
