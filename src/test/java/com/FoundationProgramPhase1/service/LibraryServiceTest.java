//package com.FoundationProgramPhase1.service;
//
//import com.FoundationProgramPhase1.core.Author;
//import com.FoundationProgramPhase1.core.EBook;
//import com.FoundationProgramPhase1.core.PaperBook;
//import com.FoundationProgramPhase1.core.User;
//import com.FoundationProgramPhase1.repositories.EBookRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//class LibraryServiceTest {
//
//    LibraryService libraryService;
//
//    @BeforeEach
//    void setLibraryService() {
//        libraryService = new LibraryService();
//    }
//
//    @Test
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
//        // Arrange and Act
//        // TODO: Populate arranged inputs
//        LibraryService actualLibraryService = new LibraryService();
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    @Test
//    void testSearchReadEBookByTitle() {
//        Scanner scanner = new Scanner("Avatar");
//        User user = new User("ivanivan", "longOne", "Ivan Georgiev", 54, "male", "123 Washington", "Munich", "Germany", "ivan@abv.bg", true);
//        List<EBook> eBooks = EBookRepository.getEBooks();
//        Assertions.assertTrue(libraryService.searchReadEBookByTitle(scanner, user, eBooks));
//    }
//
//    /**
//     * Method under test: {@link LibraryService#searchDownloadEBookByTitle(Scanner, User, List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchDownloadEBookByTitle() {
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
//        LibraryService libraryService = null;
//        Scanner scanner = null;
//        User user = null;
//        List<EBook> eBooks = null;
//
//        // Act
//        boolean actualSearchDownloadEBookByTitleResult = libraryService.searchDownloadEBookByTitle(scanner, user, eBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#askForPostpone(Scanner, User)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testAskForPostpone() {
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
//        LibraryService libraryService = null;
//        Scanner scanner = null;
//        User user = null;
//
//        // Act
//        boolean actualAskForPostponeResult = libraryService.askForPostpone(scanner, user);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#searchPaperBookByTitle(Scanner, User, List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchPaperBookByTitle() {
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
//        LibraryService libraryService = null;
//        Scanner scanner = null;
//        User user = null;
//        List<PaperBook> paperBooks = null;
//
//        // Act
//        boolean actualSearchPaperBookByTitleResult = libraryService.searchPaperBookByTitle(scanner, user, paperBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#searchBookByGenre(Scanner, List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchBookByGenre() {
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
//        LibraryService libraryService = null;
//        Scanner scanner = null;
//        List<PaperBook> paperBooks = null;
//
//        // Act
//        libraryService.searchBookByGenre(scanner, paperBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#searchBookByDescription(Scanner, List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchBookByDescription() {
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
//        LibraryService libraryService = null;
//        Scanner scanner = null;
//        List<PaperBook> paperBooks = null;
//
//        // Act
//        libraryService.searchBookByDescription(scanner, paperBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#searchBookByAuthorFirstName(Scanner, List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchBookByAuthorFirstName() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.OutOfMemoryError: Java heap space
//        //       at java.util.Arrays.copyOf(Arrays.java:3481)
//        //       at java.util.ArrayList.grow(ArrayList.java:237)
//        //       at java.util.ArrayList.grow(ArrayList.java:244)
//        //       at java.util.ArrayList.add(ArrayList.java:454)
//        //       at java.util.ArrayList.add(ArrayList.java:467)
//        //       at com.FoundationProgramPhase1.utils.OutputMessages.enterAuthorFirstName(OutputMessages.java:29)
//        //       at com.FoundationProgramPhase1.utils.LibraryUtils.returnCorrectAuthorFirstName(LibraryUtils.java:60)
//        //       at com.FoundationProgramPhase1.service.LibraryService.searchBookByAuthorFirstName(LibraryService.java:185)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        LibraryService libraryService = new LibraryService();
//        Scanner scanner = new Scanner("Please enter author's first name: ");
//        libraryService.searchBookByAuthorFirstName(scanner, new ArrayList<>());
//    }
//
//    /**
//     * Method under test: {@link LibraryService#searchBookByAuthorLastName(Scanner, List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchBookByAuthorLastName() {
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
//        LibraryService libraryService = null;
//        Scanner scanner = null;
//        List<PaperBook> paperBooks = null;
//
//        // Act
//        libraryService.searchBookByAuthorLastName(scanner, paperBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#listPaperBooks(List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testListPaperBooks() {
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
//        LibraryService libraryService = null;
//        List<PaperBook> paperBooks = null;
//
//        // Act
//        libraryService.listPaperBooks(paperBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#listEBooks(List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testListEBooks() {
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
//        LibraryService libraryService = null;
//        List<EBook> eBooks = null;
//
//        // Act
//        libraryService.listEBooks(eBooks);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#listAuthors(List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testListAuthors() {
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
//        LibraryService libraryService = null;
//        List<Author> authors = null;
//
//        // Act
//        libraryService.listAuthors(authors);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link LibraryService#listReadableEBooks(List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testListReadableEBooks() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException: Cannot invoke "com.FoundationProgramPhase1.core.EBook.getEBookReadOnlineLink()" because "eBook" is null
//        //       at com.FoundationProgramPhase1.service.LibraryService.listReadableEBooks(LibraryService.java:222)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        LibraryService libraryService = new LibraryService();
//
//        ArrayList<EBook> eBooks = new ArrayList<>();
//        eBooks.add(null);
//        libraryService.listReadableEBooks(eBooks);
//    }
//
//    /**
//     * Method under test: {@link LibraryService#listDownloadableEBooks(List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testListDownloadableEBooks() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException: Cannot invoke "com.FoundationProgramPhase1.core.EBook.getEBookDownloadLink()" because "eBook" is null
//        //       at com.FoundationProgramPhase1.service.LibraryService.listDownloadableEBooks(LibraryService.java:230)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        LibraryService libraryService = new LibraryService();
//
//        ArrayList<EBook> eBooks = new ArrayList<>();
//        eBooks.add(null);
//        libraryService.listDownloadableEBooks(eBooks);
//    }
//
//    /**
//     * Method under test: {@link LibraryService#printBooks(List)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testPrintBooks() {
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
//        LibraryService libraryService = null;
//        List<User> users = null;
//
//        // Act
//        libraryService.printBooks(users);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Methods under test:
//     *
//     * <ul>
//     *   <li>{@link LibraryService#getBorrowedBook()}
//     *   <li>{@link LibraryService#getUserEBooksReadList()}
//     * </ul>
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testGetBorrowedBook() {
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
//        LibraryService libraryService = null;
//
//        // Act
//        List<User> actualBorrowedBook = libraryService.getBorrowedBook();
//        List<User> actualUserEBooksReadList = libraryService.getUserEBooksReadList();
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//}
//
