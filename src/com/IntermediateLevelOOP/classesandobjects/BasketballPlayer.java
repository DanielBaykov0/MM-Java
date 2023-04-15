package com.IntermediateLevelOOP.classesandobjects;

import java.util.Random;

public class BasketballPlayer {

    String name;
    String nickname;
    int yearOfBirth;
    String team;

    double freeThrowPercentage;
    double pointsPerGame;
    int gamesPlayed;

    public BasketballPlayer(String name, String nickname, int yearOfBirth, String team, double freeThrowPercentage, double pointsPerGame, int gamesPlayed) {
        this.name = name;
        this.nickname = nickname;
        this.yearOfBirth = yearOfBirth;
        this.team = team;
        this.freeThrowPercentage = freeThrowPercentage;
        this.pointsPerGame = pointsPerGame;
        this.gamesPlayed = gamesPlayed;
    }

    public void freeThrow() {
        Random randomNumberGenerator = new Random();
        if (randomNumberGenerator.nextDouble(101) > freeThrowPercentage) {
            System.out.println(name + " failed to score a free throw");
        } else {
            System.out.println(name + " scored a free throw");
        }
    }
}
