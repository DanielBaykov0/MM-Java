public class CodeBlocks {

    public static void main(String[] args) {

        {
            int numberOfOwners = 5;
            {

                numberOfOwners++;
            }

            System.out.println("Number of owners: " + numberOfOwners);
        }
    }
}
