package com.BeginnerLevelFundamentals.FinalPractice;

public class Movies {

    private final String[] moviesTitles;
    private final float[] moviesRatings;


    public Movies() {
        this.moviesTitles = new String[]{"Babylon", "Amsterdam", "The Suicide Squad", "Birds of Prey"};
        this.moviesRatings = new float[]{7.2F, 6.1F, 7.2F, 6.0F};
    }

    public void printMovies() {
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
