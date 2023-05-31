package com.FoundationProgramPhase1.core;

import java.util.List;

public enum BookType {

    PAPER, EBOOK;

    private static final List<BookType> bookTypes = List.of(values());

    public List<BookType> getBookTypes() {
        return bookTypes;
    }
}
