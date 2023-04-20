package com.AdvancedLevel.generics;

import java.util.ArrayList;

public class GenericsApp {

    public static void main(String[] args) {

        Box<Integer> myFavoriteNumber = new Box<>();
        myFavoriteNumber.setTypeData(15);
        Util.displayToString(myFavoriteNumber);

        Box<String> myFavoriteActor = new Box<>();
        myFavoriteActor.setTypeData("Russel Crow");
        Util.displayToString(myFavoriteActor);

        ArrayList<Box<String>> pileOfBoxes = new ArrayList<>();
        pileOfBoxes.add(myFavoriteActor);
        pileOfBoxes.add(myFavoriteActor);
        Util.displayToString(pileOfBoxes);
    }
}
