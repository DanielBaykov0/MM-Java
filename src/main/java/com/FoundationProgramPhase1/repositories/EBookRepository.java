package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.BookType;
import com.FoundationProgramPhase1.EBook;

import java.util.ArrayList;
import java.util.List;

public class EBookRepository {

    public static List<EBook> getEBooks() {
        List<EBook> list = new ArrayList<>();
        list.add(new EBook(BookType.EBOOK, "Emma", "Jane Austen", "Novel", "Explores the concerns of genteel women", "https://openlibrary.org/read/Emma", "https://openlibrary.org/download/Emma"));
        list.add(new EBook(BookType.EBOOK, "The Grapes of Wrath", "Marcel Proust", "Thriller", "If you don't kill, you will be killed", "https://openlibrary.org/read/TheGrapesOfWrath", "https://openlibrary.org/download/TheGrapesOfWrath"));
        list.add(new EBook(BookType.EBOOK, "Fahrenheit", "Truman Capote", "Fantasy", "Where and how do you want to live?", "https://openlibrary.org/read/Fahrenheit", "https://openlibrary.org/download/Fahrenheit"));
        list.add(new EBook(BookType.EBOOK, "The Great Gatsby", "Stella Gibbons", "Novel", "The adventures of a noble man", "https://openlibrary.org/read/TheGreatGatsby", "https://openlibrary.org/download/TheGreatGatsby"));
        list.add(new EBook(BookType.EBOOK, "Of Mice and Men", "Stephen King", "Horror", "Are you alone or are you not?", "https://openlibrary.org/read/OfMiceAndMen", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Brave New World", "Thomas Hardy", "Adventure", "When everything falls apart, something new rises", "https://openlibrary.org/read/BraveNewWorld", "https://openlibrary.org/download/BraveNewWorld"));
        list.add(new EBook(BookType.EBOOK, "Their Eyes Were Watching", "Philip Reeve", "True crime", "Many victims, many suspects", "https://openlibrary.org/read/TheirEyesWereWatching", "https://openlibrary.org/download/TheirEyesWereWatching"));
        list.add(new EBook(BookType.EBOOK, "Gone with the Wind", "Jane Austen", "Romance", "Not a typical love story", "https://openlibrary.org/read/GoneWithTheWind", "https://openlibrary.org/download/GoneWithTheWind"));
        list.add(new EBook(BookType.EBOOK, "As I Lay Dying", "Stephen King", "Horror", "At the last second of your breath", "https://openlibrary.org/read/AsILayDying", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "The Sun Also Rises", "William Faulkner", "Drama", "Don't lose hope when you are at the edge", "https://openlibrary.org/read/TheSunAlsoRises", "https://openlibrary.org/download/TheSunAlsoRises"));
        list.add(new EBook(BookType.EBOOK, "The Sound and the Fury", "Georgette Heyer", "Thriller", "A car race for your life", "https://openlibrary.org/read/TheSoundAndTheFury", "https://openlibrary.org/download/TheSoundAndTheFury"));
        list.add(new EBook(BookType.EBOOK, "For Whom the Bell Tolls", "Maya Angelou", "Mystery", "When you hear a bell someone dies", "https://openlibrary.org/read/ForWhomTheBellTolls", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Pride and Prejudice", "Michael Morpurgo", "Fiction", "Fight for your rights", "https://openlibrary.org/read/PrideAndPrejudice", "https://openlibrary.org/download/PrideAndPrejudice"));
        list.add(new EBook(BookType.EBOOK, "The Fault in Our Stars", "Haruki Murakami", "History", "The consequences of our decisions", "https://openlibrary.org/read/TheFaultInOurStars", "https://openlibrary.org/download/TheFaultInOurStars"));
        list.add(new EBook(BookType.EBOOK, "Atonement", "Margaret Mitchell", "Drama", "The worst place to be is your home", "https://openlibrary.org/read/Atonement", "https://openlibrary.org/download/Atonement"));
        list.add(new EBook(BookType.EBOOK, "East of Eden", "Han Suyin", "Poetry", "The one and only goes again", "https://openlibrary.org/read/EastOfEden", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Absalom, Absalom!", "William Faulkner", "Poetry", "A love poem", "https://openlibrary.org/read/Absalom,Absalom!", "https://openlibrary.org/download/Absalom,Absalom!"));
        list.add(new EBook(BookType.EBOOK, "A Time to Kill", "Chinua Achebe", "Action", "Revenge of a man", "https://openlibrary.org/read/ATimeToKill", "https://openlibrary.org/download/ATimeToKill"));
        list.add(new EBook(BookType.EBOOK, "The House of Mirth", "Thomas Hardy", "Mystery", "A small dark house in the woods", "https://openlibrary.org/read/TheHouseOfMirth", "https://openlibrary.org/download/TheHouseOfMirth"));
        list.add(new EBook(BookType.EBOOK, "Remembrance of Things", "Scot Fitzgerald", "Fiction", "What happens when someone lives in the past", "https://openlibrary.org/read/RemembranceOfThings", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Vile Bodies", "John Steinbeck", "Western", "The city sheriff is in trouble", "https://openlibrary.org/read/VileBodies", "https://openlibrary.org/download/VileBodies"));
        list.add(new EBook(BookType.EBOOK, "A Scanner Darkly", "E. M. Foster", "Horror", "Everything turns to hell", "https://openlibrary.org/read/AScannerDarkly", "https://openlibrary.org/download/AScannerDarkly"));
        list.add(new EBook(BookType.EBOOK, "Moab is My Washpot", "Dee Brown", "Novel", "The once was a kingdom called Moab", "https://openlibrary.org/read/MoabIsMyWashpot", "https://openlibrary.org/download/MoabIsMyWashpot"));
        list.add(new EBook(BookType.EBOOK, "Rosemary and Rue", "Ernest Hemingway", "Romance", "Two best friends", "https://openlibrary.org/read/RosemaryAndRue", "https://openlibrary.org/download/RosemaryAndRue"));
        list.add(new EBook(BookType.EBOOK, "Pale Fire", "Philip Pullman", "Drama", "A cop against everyone", "https://openlibrary.org/read/PaleFire", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "Cold Comfort Farm", "Cormac Mccarthy", "Adventure", "A peaceful story of a loving family", "https://openlibrary.org/read/ColdComfortFarm", "https://openlibrary.org/download/ColdComfortFarm"));
        list.add(new EBook(BookType.EBOOK, "In Cold Blood", "Kamala Markandaya", "True crime", "Serial killer strikes again", "https://openlibrary.org/read/InColdBlood", "https://openlibrary.org/download/InColdBlood"));
        list.add(new EBook(BookType.EBOOK, "Behold, Here's Poison", "Khaled Hosseini", "Drama", "When a man and a woman are full of hatred", "https://openlibrary.org/read/Behold,Here'sPoison", "https://openlibrary.org/download/Behold,Here'sPoison"));
        list.add(new EBook(BookType.EBOOK, "Band of Brothers", "John Steinbeck", "History", "The story of two brothers", "https://openlibrary.org/read/BandOfBrothers", "https://openlibrary.org/download/BandOfBrothers"));
        list.add(new EBook(BookType.EBOOK, "Mortal Engines", "Scot Fitzgerald", "Action", "The lust to build the best engine", "https://openlibrary.org/read/MortalEngines", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "The Dark Tower", "George Martin", "Thriller", "A dark tower in the middle of nowhere", "https://openlibrary.org/read/TheDarkTower", "https://openlibrary.org/download/TheDarkTower"));
        list.add(new EBook(BookType.EBOOK, "No Wind of Blame", "Alan Hollinghurst", "Drama", "A man full of blame", "https://openlibrary.org/read/NoWindOfBlame", "https://openlibrary.org/download/NoWindOfBlame"));
        list.add(new EBook(BookType.EBOOK, "Things Fall Apart", "John Toole", "Drama", "Everything is going great until it isn't", "https://openlibrary.org/read/ThingsFallApart", "https://openlibrary.org/download/ThingsFallApart"));
        list.add(new EBook(BookType.EBOOK, "The Grapes of Wrath", "Mark Haddon", "Action", "Long hail the lord", "https://openlibrary.org/read/TheGrapesOfWrath", "Not downloadable for free"));
        list.add(new EBook(BookType.EBOOK, "His Dark Materials", "T. S. Eliot", "Fantasy", "A man's dreams", "https://openlibrary.org/read/HisDarkMaterials", "https://openlibrary.org/download/HisDarkMaterials"));
        list.add(new EBook(BookType.EBOOK, "The Waste Land", "William Thackeray", "Adventure", "A barren land whose curse must be lifted by the hero", "https://openlibrary.org/read/TheWasteLand", "https://openlibrary.org/download/TheWasteLand"));
        list.add(new EBook(BookType.EBOOK, "Of Human Bondage", "Somerset Maugham", "Drama", "Inability to control one's emotions", "https://openlibrary.org/read/OfHumanBondage", "https://openlibrary.org/download/OfHumanBondage"));
        list.add(new EBook(BookType.EBOOK, "Il Mio Carso", "Douglas Adams", "Classic", "One wild life", "https://openlibrary.org/read/IlMioCarso", "Not downloadable for free"));
        return list;
    }
}
