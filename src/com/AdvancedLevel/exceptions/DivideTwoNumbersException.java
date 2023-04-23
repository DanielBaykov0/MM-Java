package com.AdvancedLevel.exceptions;

public class DivideTwoNumbersException {

    public static void main(String[] args) {

        System.out.println(divide(30, 2));
        System.out.println(divide(15, 0));
        System.out.println("The job is finished");
    }

    private static int divide(int dividend, int divisor) {

        try {
            if (divisor == 0) {
                throw new ZeroDivisorException("The divisor can't be zero! - Custom exception");
            }
            return dividend / divisor;
        } catch (ZeroDivisorException e) {
            System.err.println("The divisor can't be zero");
            e.printStackTrace();
            return 0;
        } catch (NullPointerException e) {
            System.err.println("NullPointerException is thrown");
            return 0;
        } finally {
            System.out.println("Hey, I'm a very good tool to close files and database connections");
        }
    }
}
