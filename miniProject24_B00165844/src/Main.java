import Books.Book;
import Menu.libraryUser;
import Menu.output;
import Vars.Storage;

import static Menu.libraryUser.isReturningBook;

public class Main {
    public static void main(String[] args) {
        Book[] books = Storage.loadBooks();
        output.printMenu();
        libraryUser.libraryMenu(books);

        int index = 0;
        Storage.saveBooks(books, 0, isReturningBook);
        output.printVar(books);

    }
}