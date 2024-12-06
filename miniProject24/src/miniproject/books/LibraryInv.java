package miniproject.books;

public abstract class LibraryInv {//start of superClass libraryInv
    public String isbn;
    public int dateReleased;
    public String bookName;

    public LibraryInv(String isbn, int dateReleased, String bookName) {//constructor
        setIsbn(isbn);
        setDateReleased(dateReleased);
        setBookName(bookName);
    }

    //getter setter
    public String getIsbn() {
        return isbn;
    }
    protected String getBookName() {
        return bookName;
    }
    public int getDateReleased() {
        return dateReleased;
    }

    protected void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    protected void setDateReleased(int dateReleased) {
        this.dateReleased = dateReleased;
    }
    protected void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
