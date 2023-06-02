package com.FoundationProgramPhase1.core;

import java.util.ArrayList;
import java.util.List;
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
    private final boolean GDPR;
    private List<PaperBook> paperBookList;
    private List<EBook> eBookReadList;
    private List<EBook> eBookDownloadedList;

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
        this.paperBookList = new ArrayList<>();
        this.eBookReadList = new ArrayList<>();
        this.eBookDownloadedList = new ArrayList<>();
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

    public boolean getGDPR() {
        return GDPR;
    }

    public List<PaperBook> getPaperBookList() {
        return paperBookList;
    }

    public void setPaperBookList(List<PaperBook> paperBookList) {
        this.paperBookList = paperBookList;
    }

    public List<EBook> geteBookReadList() {
        return eBookReadList;
    }

    public void setEBookReadList(List<EBook> eBookReadList) {
        this.eBookReadList = eBookReadList;
    }

    public List<EBook> geteBookDownloadedList() {
        return eBookDownloadedList;
    }

    public void setEBookDownloadedList(List<EBook> eBookDownloadedList) {
        this.eBookDownloadedList = eBookDownloadedList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return GDPR == user.GDPR && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(userAddress, user.userAddress) && Objects.equals(userEmail, user.userEmail) && Objects.equals(paperBookList, user.paperBookList) && Objects.equals(eBookReadList, user.eBookReadList) && Objects.equals(eBookDownloadedList, user.eBookDownloadedList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, userAddress, userEmail, GDPR, paperBookList, eBookReadList, eBookDownloadedList);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userAge=" + userAge +
                ", userGender='" + userGender + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userCounty='" + userCounty + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", GDPR=" + GDPR +
                ",\n paperBookList=" + paperBookList +
                ",\n eBookReadList=" + eBookReadList +
                ",\n eBookDownloadedList=" + eBookDownloadedList +
                '}';
    }
}
