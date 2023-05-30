package com.FoundationProgramPhase1;

import java.util.List;

public class LibraryApp {

    public static void main(String[] args) {

        List<PaperBook> paperBooks = PaperBookRepository.getPaperBooks();
        for (PaperBook paperBook : paperBooks) {
            System.out.println(paperBook);
        }
    }
}
