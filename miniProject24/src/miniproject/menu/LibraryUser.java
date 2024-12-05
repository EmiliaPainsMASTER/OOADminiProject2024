package miniproject.menu;

import miniproject.exceptions.InvalidFileException;
import miniproject.interfaces.libraryItem;
import miniproject.books.Book;

import java.util.Scanner;

import static miniproject.inputoutput.Storage.saveBooks;
import static miniproject.inputoutput.Transactions.transaction;
import static miniproject.menu.Output.printMenu;
import static miniproject.menu.Output.printVar;
import static miniproject.menu.TryCatch.*;

public class LibraryUser {
    public static int indexChoice;
    public static Scanner userInput = new Scanner(System.in);

    public static void libraryMenu(libraryItem[] items) throws InvalidFileException {
        while (true) {
            printVar(items); // Display all items
            String username;
            String inputChoice;
            printMenu();
            inputChoice = mainMenuChoice();
            if (inputChoice.equalsIgnoreCase("Loan")){ // Loan an item
                loanItem(items);
            } else if (inputChoice.equalsIgnoreCase("Return"))
            { // Return an item
                returnItem(items);
            } else if (inputChoice.equalsIgnoreCase("Exit")) { // Exit
                //TODO problem where upon menu exit the books would be shown again (issue fixed- line 16 was originally below the index inputChoice at line 21/2)
                //TODO create a transaction from the user detailing books and timestamp
                System.out.println("Menu exit, your receipt will be available to you after this happens");
                transaction(indexChoice, items);
                break;
            }
        }
    }

    private static void loanItem(libraryItem[] books) throws InvalidFileException {
        while (true) {
            indexChoice = subMenuChoice(books);

            if (indexChoice < 0 || indexChoice >= books.length) {
                System.out.println("Exiting loaning process.");
                break;
            } else if (books[indexChoice].isLoaned()) {
                System.out.println("This item has already been loaned.");
            } else {
                books[indexChoice].loan();
                // Save changes to storage
                saveBooks((Book[]) books, indexChoice, false);
                break;
            }
        }
    }

    private static void returnItem(libraryItem[] books) throws InvalidFileException {
        while (true) {
            indexChoice = subMenuChoice(books);

            if (indexChoice < 0 || indexChoice >= books.length) {
                System.out.println("Exiting return process.");
                break;
            } else if (!books[indexChoice].isLoaned()) {
                System.out.println("This item has not been loaned out.");
            } else {
                books[indexChoice].returnItem();
                // Save changes to storage
                saveBooks((Book[]) books, indexChoice, true);
                break;
            }
        }
    }
}
