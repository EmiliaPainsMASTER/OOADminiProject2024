package miniproject.books;

import miniproject.interfaces.libraryItem;

public class Book extends LibraryInv implements libraryItem {
    private final String author;
    private BookLoaned loaned;

    public Book(String bookName, String author, int dateReleased, String isbn, BookLoaned loaned) {
        super(isbn, dateReleased, bookName);
        this.author = author;
        this.loaned = loaned;
    }

    public void loan() {
        if (loaned == BookLoaned.AVAILABLE) {
            loaned = BookLoaned.LOANED;
        } else {
            System.out.println("Book is already loaned.");
        }
    }

    public void returnItem() {
        if (loaned == BookLoaned.LOANED) {
            loaned = BookLoaned.AVAILABLE;
        } else {
            System.out.println("Book is already available.");
        }
    }

    public boolean isLoaned() {
        return loaned == BookLoaned.LOANED;
    }

    public void setLoaned(BookLoaned loaned) {
        this.loaned = loaned;
    }

    public String toDisplayString() {
        // Ensuring fixed-width formatting for the fields
        return String.format("%-80s %-40s %-10d %-20s %-10s",
                getBookName(),          // Book Name (60 characters wide)
                author,                 // Author (40 characters wide)
                getDateReleased(),      // Date Released (10 characters wide)
                getIsbn(),              // ISBN (20 characters wide)
                loaned.toString());     // Loaned status (10 characters wide)
    }

    //similar to above but reverts the output to what was originally in the text file (toString seems to override the PrintWriter with the toString output)
    public String toFileString() {
        return getBookName() + ", " + author + ", " + getDateReleased() + ", " + getIsbn() + ", " + loaned;
    }
}
