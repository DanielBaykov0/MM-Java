import java.time.Year;

public class IMDB {

    public static void main(String[] args) {

        String actressName = "Margot Robbie";
        int yearOfBirth = 1990;
        String[] moviesTitles = {"Babylon", "Amsterdam", "The Suicide Squad", "Birds of Prey"};
        float[] moviesRatings = {7.2F, 6.1F, 7.2F, 6.0F};

        System.out.println("My favourite actress name is " + actressName);
        System.out.println("She is born in " + yearOfBirth + " and she is " + (Year.now().getValue() - yearOfBirth) + " old");
        System.out.println("She acts in the following movies:");
        for (int i = 0; i < moviesTitles.length; i++) {
            System.out.println(moviesTitles[i] + " with " + getMoviesRatingsAssessment(moviesRatings[i]) + " rating");
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
