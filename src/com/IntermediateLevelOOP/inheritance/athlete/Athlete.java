package com.IntermediateLevelOOP.inheritance.athlete;

public class Athlete {

    private String name;
    private String nickname;
    private int yearOfBirth;
    private String team;
    private int gamesPlayed;

    public Athlete(String name, String nickname, int yearOfBirth, String team, int gamesPlayed) {
        this.name = name;
        this.nickname = nickname;
        this.yearOfBirth = yearOfBirth;
        this.team = team;
        this.gamesPlayed = gamesPlayed;
    }

    public String getName() {
        return name;
    }

    public void getBio() {
        System.out.println(name + " (" + nickname + ")");
        System.out.println("Born in " + yearOfBirth);
        System.out.println("Last team is " + team + " and played " + gamesPlayed + " games");
    }
}
