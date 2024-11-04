package Books;

public abstract class libraryInv {//start of superClass libraryInv
    private String isbn;
    private int dateReleased;
    private String bookName;

    public libraryInv(String isbn, int dateReleased, String bookName) {//constructor
        this.isbn = isbn;
        this.dateReleased = dateReleased;
        this.bookName = bookName;
    }

    //getter setter
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(int dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
