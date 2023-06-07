package com.FoundationProgramPhase1.repositories;

import com.FoundationProgramPhase1.core.BookType;
import com.FoundationProgramPhase1.core.PaperBook;

import java.util.HashMap;
import java.util.Map;

public class PaperBookRepository {

        public static Map<Integer, PaperBook> getPaperBooks() {
            Map<Integer, PaperBook> list = new HashMap<>();
            list.put(1, new PaperBook(BookType.PAPER, "Star Wars", "Luke Shaw", "Fantasy",  "Fighting in the galaxy", 111, 2, 1, null));
            list.put(2, new PaperBook(BookType.PAPER, "Star Wars", "Luke Shaw", "Fantasy",  "Fighting in the galaxy", 112, 2, 1, null));
            list.put(3, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 113, 4, 1, null));
            list.put(4, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 114, 4, 1, null));
            list.put(5, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 115, 4, 1, null));
            list.put(6, new PaperBook(BookType.PAPER, "Avatar", "James Cameron", "Fantasy", "Imaginary world", 116, 4, 1, null));
            list.put(7, new PaperBook(BookType.PAPER, "Lord of the rings", "J. R. R. Tolkien", "Fantasy", "Journey to destroy a ring", 117, 3, 1, null));
            list.put(8, new PaperBook(BookType.PAPER, "Lord of the rings", "J. R. R. Tolkien", "Fantasy", "Journey to destroy a ring", 118, 3, 1, null));
            list.put(9, new PaperBook(BookType.PAPER, "Lord of the rings", "J. R. R. Tolkien", "Fantasy", "Journey to destroy a ring", 119, 3, 1, null));
            list.put(10, new PaperBook(BookType.PAPER, "What a life", "Tom Leveen", "Autobiography", "Life ot Tom", 120, 2, 1, null));
            list.put(11, new PaperBook(BookType.PAPER, "What a life", "Tom Leveen", "Autobiography", "Life ot Tom", 121, 2, 1, null));
            return list;
    }
}
