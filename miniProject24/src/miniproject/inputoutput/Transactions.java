package miniproject.inputoutput;
import miniproject.books.Book;
import java.time.LocalDateTime;

public class Transactions {
    public static void transaction(int indexChoice, Book[] books){
        if (indexChoice > books.length || indexChoice < 0){
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
