public class ArraysApp {

    public static void main(String[] args) {

        int[] lotteryNumbers = new int[5];
        lotteryNumbers[0] = 17;
        lotteryNumbers[1] = 23;
        lotteryNumbers[2] = 67;
        lotteryNumbers[3] = 37;
        lotteryNumbers[4] = 11;

        for (int lotteryNumber : lotteryNumbers) {
            System.out.print(lotteryNumber + " ");
        }

        System.out.println();

        int[][] weeklyLotteryNumbers = {
                {1, 2, 3, 4, 5},
                {11, 21, 31, 41, 51},
                {12, 22, 32, 42, 52},
                {13, 23, 33, 43, 53}

        };

        for (int i = 0; i < weeklyLotteryNumbers.length; i++) {
            for (int j = 0; j < weeklyLotteryNumbers[i].length; j++) {
                System.out.print(weeklyLotteryNumbers[i][j] + " ");
            }
            System.out.println();
        }
    }
}
