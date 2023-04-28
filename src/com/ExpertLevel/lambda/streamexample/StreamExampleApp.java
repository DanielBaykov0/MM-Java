package com.ExpertLevel.lambda.streamexample;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExampleApp {

    public static void main(String[] args) {

        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5);

        List<Integer> outputNumbers = inputNumbers
                                    .stream()
                                    .filter(number -> number > 3)
                                    .map(number -> number * number)
                                    .collect(Collectors.toList());

        System.out.println(outputNumbers);
    }
}
