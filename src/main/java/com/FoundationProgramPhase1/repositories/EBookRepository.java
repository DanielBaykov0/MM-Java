package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.EBook;

import java.util.ArrayList;
import java.util.List;

public class EBookRepository {

    public static List<EBook> getEBooks() {
        List<EBook> list = new ArrayList<>();
        list.add(new EBook(BookType.EBOOK, "Emma", "Jane Austen", "Novel", "Explores the concerns of genteel women", 20,"Not readable", "https://openlibrary.org/download/Emma"));
        list.add(new EBook(BookType.EBOOK, "The Grapes of Wrath", "Marcel Proust", "Thriller", "If you don't kill, you will be killed", 21,"https://openlibrary.org/read/TheGrapesOfWrath", "https://openlibrary.org/download/TheGrapesOfWrath"));
        list.add(new EBook(BookType.EBOOK, "Fahrenheit", "Truman Capote", "Fantasy", "Where and how do you want to live?", 22,"Not readable", "https://openlibrary.org/download/Fahrenheit"));
        list.add(new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", 23,"https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby"));
        list.add(new EBook(BookType.EBOOK, "Of Mice and Men", "Stephen King", "Horror", "Are you alone or are you not?", 24,"https://openlibrary.org/read/OfMiceAndMen", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Brave New World", "Thomas Hardy", "Adventure", "When everything falls apart, something new rises", 25,"https://openlibrary.org/read/BraveNewWorld", "https://openlibrary.org/download/BraveNewWorld"));
        list.add(new EBook(BookType.EBOOK, "Their Eyes Were Watching", "Philip Reeve", "True crime", "Many victims, many suspects", 26,"Not readable", "https://openlibrary.org/download/TheirEyesWereWatching"));
        list.add(new EBook(BookType.EBOOK, "Gone with the Wind", "Jane Austen", "Romance", "Not a typical love story", 27,"https://openlibrary.org/read/GoneWithTheWind", "https://openlibrary.org/download/GoneWithTheWind"));
        list.add(new EBook(BookType.EBOOK, "As I Lay Dying", "Stephen King", "Horror", "At the last second of your breath", 28,"https://openlibrary.org/read/AsILayDying", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "The Sun Also Rises", "William Faulkner", "Drama", "Don't lose hope when you are at the edge", 29,"https://openlibrary.org/read/TheSunAlsoRises", "https://openlibrary.org/download/TheSunAlsoRises"));
        list.add(new EBook(BookType.EBOOK, "The Sound and the Fury", "Georgette Heyer", "Thriller", "A car race for your life", 30,"Not readable", "https://openlibrary.org/download/TheSoundAndTheFury"));
        list.add(new EBook(BookType.EBOOK, "For Whom the Bell Tolls", "Maya Angelou", "Mystery", "When you hear a bell someone dies", 31,"https://openlibrary.org/read/ForWhomTheBellTolls", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Pride and Prejudice", "Michael Morpurgo", "Fiction", "Fight for your rights", 32,"https://openlibrary.org/read/PrideAndPrejudice", "https://openlibrary.org/download/PrideAndPrejudice"));
        list.add(new EBook(BookType.EBOOK, "The Fault in Our Stars", "Haruki Murakami", "History", "The consequences of our decisions", 33,"https://openlibrary.org/read/TheFaultInOurStars", "https://openlibrary.org/download/TheFaultInOurStars"));
        list.add(new EBook(BookType.EBOOK, "Atonement", "Margaret Mitchell", "Drama", "The worst place to be is your home", 34,"https://openlibrary.org/read/Atonement", "https://openlibrary.org/download/Atonement"));
        list.add(new EBook(BookType.EBOOK, "East of Eden", "Han Suyin", "Poetry", "The one and only goes again", 35,"https://openlibrary.org/read/EastOfEden", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Absalom, Absalom", "William Faulkner", "Poetry", "A love poem", 36,"Not readable", "https://openlibrary.org/download/Absalom,Absalom!"));
        list.add(new EBook(BookType.EBOOK, "A Time to Kill", "Chinua Achebe", "Action", "Revenge of a man", 37,"https://openlibrary.org/read/ATimeToKill", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "The House of Mirth", "Thomas Hardy", "Mystery", "A small dark house in the woods", 38,"https://openlibrary.org/read/TheHouseOfMirth", "https://openlibrary.org/download/TheHouseOfMirth"));
        list.add(new EBook(BookType.EBOOK, "Remembrance of Things", "Scot Fitzgerald", "Fiction", "What happens when someone lives in the past", 39,"https://openlibrary.org/read/RemembranceOfThings", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Vile Bodies", "John Steinbeck", "Western", "The city sheriff is in trouble", 40,"https://openlibrary.org/read/VileBodies", "https://openlibrary.org/download/VileBodies"));
        return list;
    }
}
