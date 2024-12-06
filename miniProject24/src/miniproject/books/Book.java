package miniproject.books;

import miniproject.interfaces.LibraryItem;

public class Book extends LibraryInv implements LibraryItem {
    private final String author;
    private BookLoaned loaned;

    public Book(String bookName, String author, int dateReleased, String isbn, BookLoaned loaned) {
        super(isbn, dateReleased, bookName);
        this.author = author;
        this.loaned = loaned;
    }

    // checks if the book is available to be loaned, else print out otherwise
    public void loan() {
        if (loaned == BookLoaned.AVAILABLE) {
            loaned = BookLoaned.LOANED;
        } else {
            System.out.println("Book is already loaned.");
        }
    }
    // checks if the book is available to be returned, else print out otherwise
    public void returnItem() {
        if (loaned == BookLoaned.LOANED) {
            loaned = BookLoaned.AVAILABLE;
        } else {
            System.out.println("Book is already available.");
        }
    }

    // simple check to see if a book is loaned
    public boolean isLoaned() {
        return loaned == BookLoaned.LOANED;
    }

    // changing values
    public void setLoaned(BookLoaned loaned) {
        this.loaned = loaned;
    }

    public String toDisplayString() {
        // Ensuring fixed-width formatting for the fields
        return String.format("%-80s %-40s %-10d %-20s %-10s",
                getBookName(),
                author,
                getDateReleased(),
                getIsbn(),
                loaned.toString());
    }

    //similar to above but reverts the output to what was originally in the text file (toString seems to override the PrintWriter with the toString output)
    public String toFileString() {
        return getBookName() + ", " + author + ", " + getDateReleased() + ", " + getIsbn() + ", " + loaned;
    }
}
