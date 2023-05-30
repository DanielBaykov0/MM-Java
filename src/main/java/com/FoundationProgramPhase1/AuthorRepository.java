package com.FoundationProgramPhase1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    public static List<Author> getAuthors() {
        List<Author> list = new ArrayList<>();
        list.add(new Author("Luke Shaw", "Austria", LocalDate.of(1965, 5, 26), true, null));
        list.add(new Author("James Cameron", "USA", LocalDate.of(1965, 10, 26), true, null));
        list.add(new Author("J. R. R. Tolkien", "Germany", LocalDate.of(1978, 2, 6), true, null));
        list.add(new Author("Tom Leveen", "Spain", LocalDate.of(1960, 1, 2), true, LocalDate.of(2020, 2, 10)));
        list.add(new Author("Dan Brown", "England", LocalDate.of(1961, 4, 3), true, null));
        list.add(new Author("Wiley", "Italy", LocalDate.of(1962, 6, 1), true, null));
        list.add(new Author("James Patterson", "Australia", LocalDate.of(1963, 7, 4), true, null));
        list.add(new Author("Kazuo Ishiguro", "Japan", LocalDate.of(1964, 8, 5), true, null));
        list.add(new Author("Lewis Carroll", "Finland", LocalDate.of(1966, 9, 6), true, null));
        list.add(new Author("Isabel Dalhousie", "Ukraine", LocalDate.of(1967, 10, 7), true, null));
        list.add(new Author("Rebecca Serle", "Norway", LocalDate.of(1968, 11, 8), true, null));
        list.add(new Author("Paulo Coelho", "Sweden", LocalDate.of(1969, 12, 9), true, null));
        list.add(new Author("Rex Stout", "Ireland", LocalDate.of(1970, 1, 10), true, null));
        list.add(new Author("Anne Rice", "Portugal", LocalDate.of(1971, 2, 11), true, null));
        list.add(new Author("Mickey Spillane", "Poland", LocalDate.of(1972, 3, 12), true, null));
        list.add(new Author("Clive Cussler", "USA", LocalDate.of(1973, 4, 13), true, null));
        list.add(new Author("Richard Scarry", "Austria", LocalDate.of(1974, 5, 14), true, null));
        list.add(new Author("Ernest Hemingway", "Czech Republic", LocalDate.of(1975, 6, 15), true, null));
        list.add(new Author("Jacqueline Woodson", "Belgium", LocalDate.of(1976, 7, 16), true, null));
        list.add(new Author("Helen Philips", "Italy", LocalDate.of(1977, 8, 17), true, null));
        list.add(new Author("Megan Miranda", "Hungary", LocalDate.of(1978, 9, 18), true, LocalDate.of(2021, 5, 1)));
        list.add(new Author("Elsevier", "Russia", LocalDate.of(1979, 10, 19), true, LocalDate.of(2022, 12, 24)));
        list.add(new Author("Stephen King", "USA", LocalDate.of(1980, 11, 20), true, LocalDate.of(2019, 4, 6)));
        list.add(new Author("J. K. Rowling", "USA", LocalDate.of(1981, 12, 21), true, null));
        list.add(new Author("Roald Dahl", "Egypt", LocalDate.of(1965, 1, 22), true, LocalDate.of(2022, 10, 23)));
        list.add(new Author("Jess Kidd", "Sweden", LocalDate.of(1966, 2, 23), true, LocalDate.of(2021, 11, 21)));
        list.add(new Author("Jane Austen", "Finland", LocalDate.of(1967, 3, 24), true, LocalDate.of(2020, 9, 29)));
        list.add(new Author("Marcel Proust", "Norway", LocalDate.of(1968, 4, 25), true, LocalDate.of(2023, 4, 27)));
        list.add(new Author("Truman Capote", "England", LocalDate.of(1969, 5, 26), true, LocalDate.of(2021, 1, 14)));
        list.add(new Author("Stella Gibbons", "England", LocalDate.of(1970, 6, 27), true, null));
        list.add(new Author("Thomas Hardy", "England", LocalDate.of(1960, 7, 28), true, null));
        list.add(new Author("Philip Reeve", "USA", LocalDate.of(1961, 8, 29), true, null));
        list.add(new Author("William Faulkner", "USA", LocalDate.of(1962, 9, 30), true, null));
        list.add(new Author("Georgette Heyer", "Turkey", LocalDate.of(1963, 10, 1), true, null));
        list.add(new Author("Maya Angelou", "Greece", LocalDate.of(1964, 11, 2), true, null));
        list.add(new Author("Michael Morpurgo", "France", LocalDate.of(1965, 12, 3), true, null));
        list.add(new Author("Haruki Murakami", "China", LocalDate.of(1966, 1, 4), true, null));
        list.add(new Author("Margaret Mitchell", "Switzerland", LocalDate.of(1954, 2, 5), true, LocalDate.of(2019, 6, 17)));
        list.add(new Author("Han Suyin", "Japan", LocalDate.of(1955, 3, 6), true, LocalDate.of(2020, 7, 18)));
        list.add(new Author("Chinua Achebe", "China", LocalDate.of(1956, 4, 7), true, LocalDate.of(2017, 8, 19)));
        list.add(new Author("Scot Fitzgerald", "Austria", LocalDate.of(1957, 5, 8), true, LocalDate.of(2016, 2, 13)));
        list.add(new Author("John Steinbeck", "USA", LocalDate.of(1958, 6, 9), true, LocalDate.of(2016, 3, 16)));
        list.add(new Author("E. M. Foster", "England", LocalDate.of(1959, 7, 10), true, null));
        list.add(new Author("Dee Brown", "Poland", LocalDate.of(1960, 8, 11), true, null));
        list.add(new Author("Philip Pullman", "Germany", LocalDate.of(1961, 9, 12), true, null));
        list.add(new Author("Cormac Mccarthy", "Greece", LocalDate.of(1962, 10, 13), true, null));
        list.add(new Author("Kamala Markandaya", "Egypt", LocalDate.of(1955, 11, 14), true, null));
        list.add(new Author("Khaled Hosseini", "Argentina", LocalDate.of(1956, 12, 15), true, null));
        list.add(new Author("George Martin", "USA", LocalDate.of(1957, 1, 16), true, null));
        list.add(new Author("Alan Hollinghurst", "Brazil", LocalDate.of(1958, 2, 17), true, null));
        list.add(new Author("John Toole", "England", LocalDate.of(1959, 3, 18), true, null));
        list.add(new Author("Mark Haddon", "Italy", LocalDate.of(1960, 4, 19), true, LocalDate.of(2023, 6, 3)));
        list.add(new Author("T. S. Eliot", "France", LocalDate.of(1961, 5, 20), true, LocalDate.of(2020, 7, 4)));
        list.add(new Author("William Thackeray", "USA", LocalDate.of(1962, 6, 21), true, LocalDate.of(2021, 8, 8)));
        list.add(new Author("Somerset Maugham", "Austria", LocalDate.of(1963, 7, 22), true, LocalDate.of(2019, 7, 12)));
        list.add(new Author("Douglas Adams", "Australia", LocalDate.of(1965, 8, 23), true, LocalDate.of(2018, 1, 7)));
        return list;
    }
}
