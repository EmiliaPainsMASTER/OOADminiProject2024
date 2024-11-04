package Books;

public class Book extends libraryInv {//start of subClass Book which extends libraryInv
    private String author;
    private bookLoaned loaned;

    public Book(String bookName, String author, int dateReleased, String isbn, bookLoaned loaned) {//constructor
        super(isbn, dateReleased, bookName);
        this.author = author;
        this.loaned = loaned;
    }

    //getter/setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public bookLoaned getLoaned() {
        return loaned;
    }

    public void setLoaned(bookLoaned loaned) {
        this.loaned = loaned;
    }

    //toString method for outputting to menu
    public String toString() {
        return String.format("Book Name: %-80s Author: %-40s Date Released: %-15d ISBN: %-15s Loaned?: %s",
                getBookName(),
                author,
                getDateReleased(),
                getIsbn(),
                loaned);
    }

    //similar to above but reverts the output to what was originally in the text file (toString seems to override the PrintWriter with the toString output)
    public String toFileString() {
        return getBookName() + ", " + author + ", " + getDateReleased() + ", " + getIsbn() + ", " + loaned;
    }

}//end of class Book which extended libraryInv
