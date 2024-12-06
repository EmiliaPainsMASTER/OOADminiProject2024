package miniproject.menu;

import miniproject.exceptions.InvalidFileException;
import miniproject.interfaces.LibraryItem;
import miniproject.books.Book;

import java.util.Scanner;

import static miniproject.inputoutput.Storage.saveBooks;
import static miniproject.menu.Output.printMenu;
import static miniproject.menu.Output.printVar;
import static miniproject.menu.TryCatch.*;

public class LibraryUser {
    public static int indexChoice;
    public static Scanner userInput = new Scanner(System.in);

    public static void libraryMenu(LibraryItem[] books) throws InvalidFileException {
        // loops the program
        boolean exitProgram = false;
        // makes the menu loop
        while (!exitProgram) {
            // Display the main menu
            printMenu();
            // gets the user input
            String inputChoice = mainMenuChoice();
            if (inputChoice.equalsIgnoreCase("Loan")) {
                // Display books
                printVar(books);
                // uses the loanItem method
                loanItem(books);
                //clears the userInput
                userInput.nextLine();
            } else if (inputChoice.equalsIgnoreCase("Return")) {
                // Display Books
                printVar(books);
                // uses the returnItem method
                returnItem(books);
                //clears the userInput
                userInput.nextLine();
            } else if (inputChoice.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting program. A transactional receipt will be printed.");
                exitProgram = true; // End the loop
            } else {
                // displays on invalid input
                System.out.println("Invalid input. Please try use a string.");
            }
        }
    }
    //method to loan the book
    private static void loanItem(LibraryItem[] books) throws InvalidFileException {
        // Display submenu for loaning books
        indexChoice = subMenuChoice(books);

        // checks if index is valid
        if (indexChoice < 0 || indexChoice >= books.length) {
            System.out.println("Exiting loaning process.");
        } else if (books[indexChoice].isLoaned()) {
            System.out.println("This Book has already been loaned.");
        } else {
            books[indexChoice].loan();
            saveBooks((Book[]) books, indexChoice, false);
            System.out.println("Book loaned successfully.");
        }
    }
    // method for returning books
    private static void returnItem(LibraryItem[] books) throws InvalidFileException {
        // Display submenu for returning books
        indexChoice = subMenuChoice(books);

        // Inline validation for index range
        if (indexChoice < 0 || indexChoice >= books.length) {
            System.out.println("Exiting return process.");
        } else if (!books[indexChoice].isLoaned()) {
            System.out.println("This Book has not been loaned.");
        } else {
            books[indexChoice].returnItem();
            saveBooks((Book[]) books, indexChoice, true);
            System.out.println("Book returned successfully.");
        }
    }
}
