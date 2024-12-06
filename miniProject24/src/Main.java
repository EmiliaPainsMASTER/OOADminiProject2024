import miniproject.books.Book;
import miniproject.exceptions.InvalidFileException;

import static miniproject.inputoutput.Storage.loadBooks;
import static miniproject.inputoutput.Transactions.transaction;
import static miniproject.menu.LibraryUser.indexChoice;
import static miniproject.menu.LibraryUser.libraryMenu;

public class Main {
    public static void main(String[] args) throws InvalidFileException {
        boolean test = true;
        Book[] books = loadBooks();
        libraryMenu(books);
        // uses the transaction methods to print the receipt
        transaction(indexChoice, books);

        if(test){
            for (int i = 0; i<books.length; i++){
                books[i].toDisplayString();
            }
        }
    }
}