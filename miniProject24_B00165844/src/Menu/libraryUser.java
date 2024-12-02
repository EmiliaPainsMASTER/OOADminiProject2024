package Menu;

import Books.Book;
import Books.bookLoaned;
import Vars.Storage;

import java.util.Scanner;

public class libraryUser {
    public static boolean isReturningBook;
    public static int indexChoice;
    protected static boolean loop = true;
    static Scanner userInput = new Scanner(System.in);

    public static void libraryMenu(Book[] books) {
        while (loop) {
            int inputChoice;
            output.printMenu();
            System.out.print("Please enter an index to use the program: ");
            inputChoice = userInput.nextInt();
            System.out.println();
            output.printVar(books);

            if (inputChoice == 1) { // Loan a book
                loanBook(books);
            } else if (inputChoice == 2) { // Return a book
                returnBook(books);
            } else if (inputChoice == 3) { // Exit
                break;
            }
        }
    }

    private static void loanBook(Book[] books) {
        boolean isNotLoaned = true;
        while (isNotLoaned) {
            System.out.print("Which book would you like to loan out? Alternatively you can enter 0 to leave the submenu. (Use index 1 to " + books.length + "): ");
            indexChoice = userInput.nextInt() - 1; // Subtract 1 to align with array index

            if (indexChoice < 0 || indexChoice >= books.length) {
                System.out.println("Exiting loaning process.");
                isNotLoaned = false;
            } else if (books[indexChoice].getLoaned() == bookLoaned.Loaned) {
                System.out.println("This book has already been loaned.");
            } else {
                System.out.println("Thank you for your order! Your selected book:");
                books[indexChoice].setLoaned(bookLoaned.Loaned);
                System.out.println("##[" + (indexChoice + 1) + "] " + books[indexChoice]);
                isReturningBook = false;
                isNotLoaned = false;

                // Save the updated books array to file
                Storage.saveBooks(books, indexChoice, isReturningBook); // Pass zero-based index
            }
        }
    }

    private static void returnBook(Book[] books) {
        boolean isReturning = true;
        while (isReturning) {
            System.out.print("Which book would you like to return? Alternatively, you can enter 0 to leave the submenu. (Use index 1 to " + books.length + "): ");
            indexChoice = userInput.nextInt() - 1; // Subtract 1 to align with array index

            if (indexChoice < 0 || indexChoice >= books.length) {
                System.out.println("Exiting return process.");
                isReturning = false;
            } else if (books[indexChoice].getLoaned() == bookLoaned.Available) {
                System.out.println("This book has not been loaned out.");
            } else if (books[indexChoice].getLoaned() == bookLoaned.Loaned) {
                System.out.println("Thank you for returning the book!");
                books[indexChoice].setLoaned(bookLoaned.Available);
                isReturningBook = true;
                isReturning = false;

                // Save the updated books array to file
                Storage.saveBooks(books, indexChoice, isReturningBook); // Pass zero-based index
            }
        }
    }

}
