package miniproject.books;

public abstract class LibraryInv {//start of superClass libraryInv
    private String isbn;
    private int dateReleased;
    private String bookName;

    public LibraryInv(String isbn, int dateReleased, String bookName) {//constructor
        setIsbn(isbn);
        setDateReleased(dateReleased);
        setBookName(bookName);
    }

    //getter setter
    protected String getIsbn() {
        return isbn;
    }
    public String getBookName() {
        return bookName;
    }
    protected int getDateReleased() {
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
