package com.FoundationProgramPhase1.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTypeTest {

    @Test
    void testBookPaperType() {
        List<BookType> bookTypeList = List.of(BookType.values());
        BookType bookTypePaper = BookType.PAPER;
        assertTrue(bookTypeList.contains(bookTypePaper));
    }

    @Test
    void testBookEBookType() {
        List<BookType> bookTypeList = List.of(BookType.values());
        BookType bookTypePaper = BookType.EBOOK;
        assertTrue(bookTypeList.contains(bookTypePaper));
    }
}

