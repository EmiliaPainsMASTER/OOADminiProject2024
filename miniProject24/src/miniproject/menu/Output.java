package miniproject.menu;

import miniproject.interfaces.LibraryItem;

public class Output {
    public static void printMenu() {
        System.out.println("Enter 'Loan' if you want to loan Items");
        System.out.println("Enter 'Return' if you want to return Items");
        System.out.println("Enter 'Exit' if you want to leave the program");
    }

    public static void printVar(LibraryItem[] items) {
        for (int i = 0; i < items.length; i++) {
            int count = i + 1; // Adjust for 1-based indexing
            if (count < 10) { // Single-digit index
                System.out.println("[" + count + "]  " + items[i].toDisplayString());
            } else { // Double-digit index
                System.out.println("[" + count + "] " + items[i].toDisplayString());
            }
        }
        System.out.println();
    }
}
