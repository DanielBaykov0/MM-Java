package com.FoundationProgramPhase1;

import java.util.ArrayList;
import java.util.List;

public class PaperBookRepository {

    public static List<PaperBook> getPaperBooks() {
            List<PaperBook> list = new ArrayList<>();
            list.add(new PaperBook(BookType.PAPER, "Star Wars", "Luke Shaw", "Fantasy", "Fighting in the galaxy", 2));
            list.add(new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 4));
            list.add(new PaperBook(BookType.PAPER, "Lord of the rings", "J. R. R. Tolkien", "Fantasy", "Journey to destroy a ring", 12));
            list.add(new PaperBook(BookType.PAPER, "What a life", "Tom Leveen", "Autobiography", "Life ot Tom", 5));
            list.add(new PaperBook(BookType.PAPER, "Game on", "Dan Brown", "Fiction", "Playing cards story", 7));
            list.add(new PaperBook(BookType.PAPER, "Firefighters", "Wiley", "Action fiction", "A story for firefighters", 9));
            list.add(new PaperBook(BookType.PAPER, "World of cats", "James Patterson", "Novel", "The story of three cats", 11));
            list.add(new PaperBook(BookType.PAPER, "How to become a doctor", "Kazuo Ishiguro", "Guidebook", "Educative book for doctors", 6));
            list.add(new PaperBook(BookType.PAPER, "Be more productive", "Lewis Carroll", "Guidebook", "How to be more productive", 24));
            list.add(new PaperBook(BookType.PAPER, "Geometry", "Isabel Dalhousie", "Science", "Everything about geometry explained", 3));
            list.add(new PaperBook(BookType.PAPER, "Statistics", "Isabel Dalhousie", "Science", "Everything about statistics explained", 1));
            list.add(new PaperBook(BookType.PAPER, "Life of dinosaurs", "Rebecca Serle", "Fantasy", "How dinosaurs lived", 7));
            list.add(new PaperBook(BookType.PAPER, "The Wedding", "Jess Kidd", "Romance", "When a guy meets a woman", 6));
            list.add(new PaperBook(BookType.PAPER, "8 perfect murders", "Paulo Coelho", "True crime", "Detective tries to catch a murderer", 5));
            list.add(new PaperBook(BookType.PAPER, "Learn the alphabet", "Rex Stout", "Guidebook", "Alphabet guide", 4));
            list.add(new PaperBook(BookType.PAPER, "Beloved", "Anne Rice", "Romance", "Loving story...", 9));
            list.add(new PaperBook(BookType.PAPER, "To Kill a Mockingbird", "Mickey Spillane", "Thriller", "Unexpected ending", 6));
            list.add(new PaperBook(BookType.PAPER, "A Passage to India", "Clive Cussler", "Adventure", "Journey to the desired country", 3));
            list.add(new PaperBook(BookType.PAPER, "Gone Girl", "Richard Scarry", "Mystery", "A girl went missing and...", 2));
            list.add(new PaperBook(BookType.PAPER, "Life of Pi", "Ernest Hemingway", "Fiction", "Follows the life of Pi", 5));
            list.add(new PaperBook(BookType.PAPER, "Animal Farm", "Jacqueline Woodson", "Drama", "A wonderful life to live in a farm", 4));
            list.add(new PaperBook(BookType.PAPER, "The Water Dancer", "Helen Philips", "Fairy tale", "Story about a samurai", 8));
            list.add(new PaperBook(BookType.PAPER, "Memoirs of a Geisha", "Megan Miranda", "Autobiography", "Follows the life of a Geisha", 10));
            list.add(new PaperBook(BookType.PAPER, "The Glass Castle", "Elsevier", "Novel", "An imaginary castle full of imaginary people", 11));
            list.add(new PaperBook(BookType.PAPER, "Carie", "Stephen King", "Horror", "Who is going to die?", 12));
            list.add(new PaperBook(BookType.PAPER, "A Tale of Two Cities", "Stephen King", "Historical fiction", "The fight between two cities. What are they fighting for?", 13));
            list.add(new PaperBook(BookType.PAPER, "Harry Potter", "J. K. Rowling", "Fantasy", "Magical creatures", 14));
            list.add(new PaperBook(BookType.PAPER, "The Hobbit", "J. R. R. Tolkien", "Fantasy", "Journey to the end of the world", 15));
            list.add(new PaperBook(BookType.PAPER, "The Da Vinci Code", "Dan Brown", "Science", "Break the unbreakable", 16));
            list.add(new PaperBook(BookType.PAPER, "She", "Roald Dahl", "Humor", "A life full of banter", 17));
            list.add(new PaperBook(BookType.PAPER, "The Little Prince", "Jess Kidd", "Historical fiction", "The boy who became a prince", 9));
            return list;
    }
}
