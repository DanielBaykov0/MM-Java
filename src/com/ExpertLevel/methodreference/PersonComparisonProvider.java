package com.ExpertLevel.methodreference;

import java.util.Comparator;

public class PersonComparisonProvider {

    public int compareByNameAndAge(Person person1, Person person2) {
        return Comparator.comparing(Person::getName).thenComparing(Person::getAge).compare(person1, person2);
    }
}
