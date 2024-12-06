package miniproject.inputoutput;
<<<<<<< Updated upstream
import miniproject.books.LibraryInv;
import miniproject.interfaces.LibraryItem;

=======
import miniproject.books.Book;
>>>>>>> Stashed changes
import java.time.LocalDateTime;

public class Transactions {
    //TODO make a transaction file to save to, and output to user when user finishes
<<<<<<< Updated upstream
    public static void transaction(int indexChoice, LibraryItem[] items){
        System.out.println("Index: " + indexChoice);
        if (indexChoice > items.length || indexChoice < 0){
=======
    public static void transaction(int indexChoice, Book[] books){
        if (indexChoice > books.length || indexChoice < 0){
>>>>>>> Stashed changes
            System.out.println("Invalid Index! Exiting program");
        }
        else{
            System.out.println("  Receipt");
            System.out.println("_____________");
            System.out.println("time: " + LocalDateTime.now());
            System.out.println("Book: " + books[indexChoice].toTransactionString());
        }
    }
}
