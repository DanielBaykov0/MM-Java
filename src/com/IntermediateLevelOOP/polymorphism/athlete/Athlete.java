package com.IntermediateLevelOOP.polymorphism.athlete;

public abstract class Athlete {

    private String name;
    private String nickname;
    private int yearOfBirth;
    private String team;
    private int numberOfCompetitions;

    public Athlete(String name, String nickname, int yearOfBirth, String team, int numberOfCompetitions) {
        this.name = name;
        this.nickname = nickname;
        this.yearOfBirth = yearOfBirth;
        this.team = team;
        this.numberOfCompetitions = numberOfCompetitions;
    }

    public String getName() {
        return name;
    }

    public void getBio() {
        System.out.println(name + " (" + nickname + ")");
        System.out.println("Born in " + yearOfBirth);
        System.out.println("Last team is " + team + " and took part in " + numberOfCompetitions + " competitions");
    }

    public void compete() {
        System.out.println(name + " took part in a competition");
        numberOfCompetitions++;
    }

    public abstract String getBodyType();

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
