package Menu;

import Books.Book;
import Interface.libraryItem;
import Vars.Storage;

import java.util.Scanner;

public class libraryUser {
    public static boolean isReturningItem;
    public static int indexChoice;
    protected static boolean loop = true;
    static Scanner userInput = new Scanner(System.in);

    public static void libraryMenu(libraryItem[] items) {
        while (loop) {
            int inputChoice;
            output.printMenu();
            System.out.print("Please enter an index to use the program: ");
            inputChoice = userInput.nextInt();
            System.out.println();
            output.printVar((Book[]) items); // Display all items

            if (inputChoice == 1) { // Loan an item
                loanItem(items);
            } else if (inputChoice == 2) { // Return an item
                returnItem(items);
            } else if (inputChoice == 3) { // Exit
                System.out.println("Exiting library menu. Goodbye!");
                loop = false;
            }
        }
    }

    private static void loanItem(libraryItem[] items) {
        boolean isNotLoaned = true;
        while (isNotLoaned) {
            System.out.print("Which item would you like to loan out? Alternatively, you can enter 0 to leave the submenu. (Use index 1 to " + items.length + "): ");
            indexChoice = userInput.nextInt() - 1;

            if (indexChoice < 0 || indexChoice >= items.length) {
                System.out.println("Exiting loaning process.");
                isNotLoaned = false;
            } else if (items[indexChoice].isLoaned()) {
                System.out.println("This item has already been loaned.");
            } else {
                items[indexChoice].loan();
                isNotLoaned = false;

                // Save changes to storage
                Storage.saveBooks((Books.Book[]) items, indexChoice, false);
            }
        }
    }

    private static void returnItem(libraryItem[] items) {
        boolean isReturning = true;
        while (isReturning) {
            System.out.print("Which item would you like to return? Alternatively, you can enter 0 to leave the submenu. (Use index 1 to " + items.length + "): ");
            indexChoice = userInput.nextInt() - 1;

            if (indexChoice < 0 || indexChoice >= items.length) {
                System.out.println("Exiting return process.");
                isReturning = false;
            } else if (!items[indexChoice].isLoaned()) {
                System.out.println("This item has not been loaned out.");
            } else {
                items[indexChoice].returnItem();
                isReturning = false;

                // Save changes to storage
                Storage.saveBooks((Books.Book[]) items, indexChoice, true);
            }
        }
    }
}
