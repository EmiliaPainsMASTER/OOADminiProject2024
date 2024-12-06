package miniproject.menu;

import miniproject.exceptions.InvalidFileException;
import miniproject.interfaces.LibraryItem;
import miniproject.books.Book;

import java.util.Scanner;

import static miniproject.inputoutput.Storage.saveBooks;
import static miniproject.inputoutput.Transactions.transaction;
import static miniproject.menu.Output.printMenu;
import static miniproject.menu.Output.printVar;
import static miniproject.menu.TryCatch.*;

public class LibraryUser {
    public static int indexChoice;
    // take user input
    public static Scanner userInput = new Scanner(System.in);

<<<<<<< Updated upstream
    public static void libraryMenu(LibraryItem[] items) throws InvalidFileException {
        while (true) {
            printVar(items); // Display all items
            String username;
            String inputChoice;
            printMenu();
            inputChoice = mainMenuChoice();
            if (inputChoice.equals("Loan") || inputChoice.equals("loan") || inputChoice.equals("LOAN")){
                // Loan an item
                loanItem(items);
            } else if (inputChoice.equals("Return") || inputChoice.equals("return")|| inputChoice.equals("RETURN")) {
                // Return an item
                returnItem(items);
            } else if (inputChoice.equals("Exit")|| inputChoice.equals("exit")|| inputChoice.equals("EXIT")) { // Exit
                //TODO problem where upon menu exit the books would be shown again (issue fixed- line 16 was originally below the index inputChoice at line 21/2)
                //TODO create a transaction from the user detailing book and timestamp
                System.out.println("Menu exit, your receipt will be available to you after this happens");
                transaction(indexChoice, items);
                break;
=======
    public static void libraryMenu(LibraryItem[] books) throws InvalidFileException {
        // allows the program to loop the menu
        boolean exitProgram = false;

        while (!exitProgram) {
            // Display the main menu
            printMenu();
            // takes input from mainMenuChoice
            String inputChoice = mainMenuChoice();

            if (inputChoice.equalsIgnoreCase("Loan")) {
                // Display books
                printVar(books);
                // uses the loanItem method
                loanItem(books);
                // clears the scanner
                userInput.nextLine();
            } else if (inputChoice.equalsIgnoreCase("Return")) {
                // Display books
                printVar(books);
                // uses the returnItem method
                returnItem(books);
                // clears the scanner
                userInput.nextLine();
            } else if (inputChoice.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting program. A transactional receipt will be generated.");
                // uses the transaction methods to print the receipt
                // finishes the loop
                exitProgram = true;
            // if there is invalid input
            } else {
                System.out.println("Invalid input. Please enter a STRING.");
>>>>>>> Stashed changes
            }
        }
    }

    private static void loanItem(LibraryItem[] books) throws InvalidFileException {
<<<<<<< Updated upstream
        while (true) {
            indexChoice = subMenuChoice(books);
=======
        // Display submenu for loaning books
        indexChoice = subMenuChoice(books);
>>>>>>> Stashed changes

        // checking if it's a valid input
        if (indexChoice < 0 || indexChoice >= books.length) {
            System.out.println("Exiting loaning process.");
        } else if (books[indexChoice].isLoaned()) {
            System.out.println("This item has already been loaned.");
        } else {
            books[indexChoice].loan();
            saveBooks((Book[]) books, indexChoice, false);
            System.out.println("Book loaned successfully.");
        }
    }

    private static void returnItem(LibraryItem[] books) throws InvalidFileException {
<<<<<<< Updated upstream
        while (true) {
            indexChoice = subMenuChoice(books);
=======
        // Display submenu for returning books
        indexChoice = subMenuChoice(books);
>>>>>>> Stashed changes

        // checks if the index is valid
        if (indexChoice < 0 || indexChoice >= books.length) {
            System.out.println("Exiting return process.");
        } else if (!books[indexChoice].isLoaned()) {
            System.out.println("This item has not been loaned.");
        } else {
            books[indexChoice].returnItem();
            saveBooks((Book[]) books, indexChoice, true);
            System.out.println("Book returned successfully.");
        }
    }
}
