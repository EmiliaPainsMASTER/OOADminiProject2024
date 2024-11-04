package Vars;

import Books.Book;
import Books.bookLoaned;

public class Storage {
    public static Book[] loadBooks() {
        Book effectiveJava = new Book("Effective Java", "Joshua Bloch", 2008, "9780134686097", bookLoaned.Available);
        Book cleanCode = new Book("Clean Code", "Robert C. Martin", 2008, "9780136083238", bookLoaned.Available);
        Book designPatterns = new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", 1994, "9780201633610", bookLoaned.Available);
        Book javaCompleteReference = new Book("Java: The Complete Reference", "Herbert Schildt", 2018, "9781260440218", bookLoaned.Available);
        Book headFirstDesignPatterns = new Book("Head First Design Patterns", "Eric Freeman", 2004, "9780596007126", bookLoaned.Available);
        Book pragmaticProgrammer = new Book("The Pragmatic Programmer", "Andrew Hunt", 1999, "9780201616224", bookLoaned.Available);
        Book refactoring = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", 1999, "9780201485677", bookLoaned.Available);
        Book theoryOfComputation = new Book("Introduction to the Theory of Computation", "Michael Sipser", 1997, "9780534950972", bookLoaned.Available);
        Book aiModernApproach = new Book("Artificial Intelligence: A Modern Approach", "Stuart Russell", 2010, "9780136042594", bookLoaned.Available);
        Book youDontKnowJs = new Book("You Don’t Know JS", "Kyle Simpson", 2014, "9781491950296", bookLoaned.Available);
        return new Book[]{effectiveJava, cleanCode, designPatterns, javaCompleteReference, headFirstDesignPatterns, pragmaticProgrammer, refactoring, theoryOfComputation, aiModernApproach, youDontKnowJs};
    }
}

