public class ControlFlowPractice {

    public static void main(String[] args) {

        char c = 'C';
        String fatherOfTheLightBulb = "Tomas Edison";

        System.out.println("Who is named as the father of the light bulb?");

        switch (c) {
            case 'C':
                System.out.println("You are right! " + "The father is " + fatherOfTheLightBulb);
                break;
            default:
                System.out.println("Wrong answer");
        }
    }
}
