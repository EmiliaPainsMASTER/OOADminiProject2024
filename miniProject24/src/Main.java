import miniproject.books.Book;
import miniproject.exceptions.InvalidFileException;

import static miniproject.inputoutput.Storage.loadBooks;
import static miniproject.menu.libraryUser.libraryMenu;

public class Main {
    public static void main(String[] args) throws InvalidFileException {
        Book[] books = loadBooks();
        libraryMenu(books);
    }
}