import Books.Book;
import Menu.libraryUser;
import Vars.Storage;

public class Main {
    public static void main(String[] args) {
        Book[] books = Storage.loadBooks();
        libraryUser.libraryMenu(books);
    }
}