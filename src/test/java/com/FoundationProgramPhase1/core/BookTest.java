//package com.FoundationProgramPhase1.core;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//import com.FoundationProgramPhase1.core.Book;
//import com.FoundationProgramPhase1.core.BookType;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//class BookTest {
//    /**
//     * Method under test: {@link Book#Book(BookType, String, String, String, String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testConstructor() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        BookType bookType = BookType.PAPER;
//        String bookTitle = "";
//        String bookAuthor = "";
//        String bookGenre = "";
//        String bookDescription = "";
//
//        // Act
//        Book actualBook = new Book(bookType, bookTitle, bookAuthor, bookGenre, bookDescription);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link Book#provideISBN()}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testProvideISBN() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//
//        // Act
//        long actualProvideISBNResult = book.provideISBN();
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link Book#checkISBN(long)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testCheckISBN() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//        long number = 0L;
//
//        // Act
//        boolean actualCheckISBNResult = book.checkISBN(number);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link Book#generateISBN()}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testGenerateISBN() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//        //       at java.util.Collections$SingletonList.forEach(Collections.java:4966)
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//
//        // Act
//        long actualGenerateISBNResult = book.generateISBN();
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Methods under test:
//     *
//     * <ul>
//     *   <li>{@link Book#getBookAuthor()}
//     *   <li>{@link Book#getBookDescription()}
//     *   <li>{@link Book#getBookGenre()}
//     *   <li>{@link Book#getBookTitle()}
//     *   <li>{@link Book#getBookType()}
//     *   <li>{@link Book#getISBN()}
//     *   <li>{@link Book#toString()}
//     * </ul>
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testGetBookAuthor() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//        //       at java.util.ArrayList.forEach(ArrayList.java:1511)
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//
//        // Act
//        String actualBookAuthor = book.getBookAuthor();
//        String actualBookDescription = book.getBookDescription();
//        String actualBookGenre = book.getBookGenre();
//        String actualBookTitle = book.getBookTitle();
//        BookType actualBookType = book.getBookType();
//        long actualISBN = book.getISBN();
//        String actualToStringResult = book.toString();
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link Book#equals(Object)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testEquals() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//        Object object = null;
//
//        // Act
//        boolean actualEqualsResult = book.equals(object);
//
//        // Assert
//        assertNotEquals(book, object);
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link Book#equals(Object)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testEquals2() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//        String string = "Different type to Book";
//
//        // Act
//        boolean actualEqualsResult = book.equals(string);
//
//        // Assert
//        assertNotEquals(book, string);
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link Book#equals(Object)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testEquals3() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//        Book book2 = null;
//
//        // Act
//        boolean actualEqualsResult = book.equals(book2);
//
//        // Assert
//        assertNotEquals(book, book2);
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Methods under test:
//     *
//     * <ul>
//     *   <li>{@link Book#equals(Object)}
//     *   <li>{@link Book#hashCode()}
//     * </ul>
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testEquals4() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//
//        // Act
//        boolean actualEqualsResult = book.equals(book);
//
//        // Assert
//        assertEquals(book, book);
//        int actualHashCodeResult = book.hashCode();
//        assertEquals(book.hashCode(), actualHashCodeResult);
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Methods under test:
//     *
//     * <ul>
//     *   <li>{@link Book#equals(Object)}
//     *   <li>{@link Book#hashCode()}
//     * </ul>
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testEquals5() {
//        // TODO: Complete this test.
//        //   Reason: R006 Static initializer failed.
//        //   The static initializer of
//        //   org.mockito.Mockito
//        //   threw java.lang.NoClassDefFoundError while trying to load it.
//        //   Make sure the static initializer of Mockito
//        //   can be executed without throwing exceptions.
//        //   Exception: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.Mockito
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        Book book = null;
//        Book book2 = null;
//
//        // Act
//        boolean actualEqualsResult = book.equals(book2);
//
//        // Assert
//        assertEquals(book, book2);
//        int actualHashCodeResult = book.hashCode();
//        assertEquals(book2.hashCode(), actualHashCodeResult);
//        // TODO: Add assertions on result
//    }
//}
//
