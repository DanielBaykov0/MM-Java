package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.PaperBook;

import java.util.ArrayList;
import java.util.List;

public class PaperBookRepository {

        public static List<PaperBook> getPaperBooks() {
            List<PaperBook> list = new ArrayList<>();
            list.add(new PaperBook(BookType.PAPER, "Star Wars", "Luke Shaw", "Fantasy",  "Fighting in the galaxy", 1, 2, 2, null));
            list.add(new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 2, 4, 4, null));
            list.add(new PaperBook(BookType.PAPER, "Lord of the rings", "J. R. R. Tolkien", "Fantasy", "Journey to destroy a ring", 3, 12, 12, null));
            list.add(new PaperBook(BookType.PAPER, "What a life", "Tom Leveen", "Autobiography", "Life ot Tom", 4, 5, 5, null));
            list.add(new PaperBook(BookType.PAPER, "Game on", "Dan Brown", "Fiction", "Playing cards story", 5, 7, 7, null));
            list.add(new PaperBook(BookType.PAPER, "Firefighters", "Wiley", "Action fiction", "A story for firefighters", 6,9, 9, null));
            list.add(new PaperBook(BookType.PAPER, "World of cats", "James Patterson", "Novel", "The story of three cats", 7,11, 11, null));
            list.add(new PaperBook(BookType.PAPER, "How to become a doctor", "Kazuo Ishiguro", "Guidebook", "Educative book for doctors", 8,6, 6, null));
            list.add(new PaperBook(BookType.PAPER, "Be more productive", "Lewis Carroll", "Guidebook", "How to be more productive", 9,24, 24, null));
            list.add(new PaperBook(BookType.PAPER, "Geometry", "Isabel Dalhousie", "Science", "Everything about geometry explained", 10, 3, 3, null));
            list.add(new PaperBook(BookType.PAPER, "Statistics", "Isabel Dalhousie", "Science", "Everything about statistics explained", 11, 1, 1, null));
            list.add(new PaperBook(BookType.PAPER, "Life of dinosaurs", "Rebecca Serle", "Fantasy", "How dinosaurs lived", 12,7, 7, null));
            list.add(new PaperBook(BookType.PAPER, "The Wedding", "Jess Kidd", "Romance", "When a guy meets a woman", 13, 6, 6, null));
            list.add(new PaperBook(BookType.PAPER, "8 perfect murders", "Paulo Coelho", "True crime", "Detective tries to catch a murderer", 14,5, 5, null));
            list.add(new PaperBook(BookType.PAPER, "Learn the alphabet", "Rex Stout", "Guidebook", "Alphabet guide", 15, 4, 4, null));
            return list;
    }
}
