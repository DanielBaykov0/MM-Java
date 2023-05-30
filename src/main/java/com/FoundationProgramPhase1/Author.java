package com.FoundationProgramPhase1;

import java.time.LocalDate;
import java.util.Objects;

public class Author {

    private final String authorName;
    private final String authorCountryBorn;
    private final LocalDate authorBirthDate;
    private final boolean isAuthorAlive;
    private final LocalDate authorDeathDate;

    public Author(String authorName, String authorCountryBorn, LocalDate authorBirthDate, boolean isAuthorAlive, LocalDate authorDeathDate) {
        this.authorName = authorName;
        this.authorCountryBorn = authorCountryBorn;
        this.authorBirthDate = authorBirthDate;
        this.isAuthorAlive = isAuthorAlive;
        this.authorDeathDate = authorDeathDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorCountryBorn() {
        return authorCountryBorn;
    }

    public LocalDate getAuthorBirthDate() {
        return authorBirthDate;
    }

    public boolean isAuthorAlive() {
        return isAuthorAlive;
    }

    public LocalDate getAuthorDeathDate() {
        return authorDeathDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return isAuthorAlive == author.isAuthorAlive && Objects.equals(authorName, author.authorName) && Objects.equals(authorCountryBorn, author.authorCountryBorn) && Objects.equals(authorBirthDate, author.authorBirthDate) && Objects.equals(authorDeathDate, author.authorDeathDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName, authorCountryBorn, authorBirthDate, isAuthorAlive, authorDeathDate);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorCountryBorn='" + authorCountryBorn + '\'' +
                ", authorBirthDate=" + authorBirthDate +
                ", isAuthorAlive=" + isAuthorAlive +
                ", authorDeathDate=" + authorDeathDate +
                '}';
    }
}
