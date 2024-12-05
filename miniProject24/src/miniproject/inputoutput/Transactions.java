package miniproject.inputoutput;
import miniproject.interfaces.libraryItem;

import java.time.LocalDateTime;

public class Transactions {
    //TODO make a transaction file to save to, and output to user when user finishes
    public static void transaction(int indexChoice, libraryItem[] items){
        System.out.println("Index: " + indexChoice);
        if (indexChoice > items.length || indexChoice < 0){
            System.out.println("Invalid Index! Exiting program");
        }
        else{
            System.out.println("  Receipt");
            System.out.println("_____________");
            System.out.println("time: " + LocalDateTime.now());
            System.out.println("Book: " + items[indexChoice].toDisplayString());
        }
    }
}
