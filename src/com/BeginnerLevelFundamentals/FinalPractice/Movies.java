package com.BeginnerLevelFundamentals.FinalPractice;

import java.time.Year;

public class Movies {

    private final String actressName;
    private final int yearOfBirth;
    private final String[] moviesTitles;
    private final float[] moviesRatings;


    public Movies() {
        this.actressName = "Margot Robbie";
        this.yearOfBirth = 1990;
        this.moviesTitles = new String[]{"Babylon", "Amsterdam", "The Suicide Squad", "Birds of Prey"};
        this.moviesRatings = new float[]{7.2F, 6.1F, 7.2F, 6.0F};
    }

    public void printBio() {
        System.out.println("My favourite actress name is " + actressName);
        System.out.println("She is born in " + yearOfBirth + " and she is " + (Year.now().getValue() - yearOfBirth) + " years old");
        System.out.println("She acts in the following movies:");
        for (int i = 0; i < moviesTitles.length; i++) {
            System.out.println(moviesTitles[i] + " - " + getMoviesRatingsAssessment(moviesRatings[i]) + " rating");
        }
    }

    static String getMoviesRatingsAssessment(float rating) {
        if (rating <= 5.0) {
            return "bad";
        } else if (rating > 5 && rating <= 6.5) {
            return "average";
        } else if (rating > 6.5 && rating <= 7.0) {
            return "good";
        } else if (rating > 7.0 && rating <= 8.0) {
            return "very good";
        } else {
            return "amazing";
        }
    }
}
