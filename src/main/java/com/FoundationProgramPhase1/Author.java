package com.FoundationProgramPhase1;

import java.time.LocalDate;
import java.util.Objects;

public class Author {

    private final String authorFirstName;
    private final String authorLastName;
    private final String authorCountryBorn;
    private final LocalDate authorBirthDate;
    private final boolean isAuthorAlive;
    private final LocalDate authorDeathDate;

    public Author(String authorFirstName, String authorLastName, String authorCountryBorn, LocalDate authorBirthDate, boolean isAuthorAlive, LocalDate authorDeathDate) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorCountryBorn = authorCountryBorn;
        this.authorBirthDate = authorBirthDate;
        this.isAuthorAlive = isAuthorAlive;
        this.authorDeathDate = authorDeathDate;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
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
        return isAuthorAlive == author.isAuthorAlive && Objects.equals(authorFirstName, author.authorFirstName) && Objects.equals(authorLastName, author.authorLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorFirstName, authorLastName, isAuthorAlive);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", authorCountryBorn='" + authorCountryBorn + '\'' +
                ", authorBirthDate=" + authorBirthDate +
                ", isAuthorAlive=" + isAuthorAlive +
                ", authorDeathDate=" + authorDeathDate +
                '}';
    }
}
