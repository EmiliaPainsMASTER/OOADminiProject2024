package Menu;

import Books.Book;

import java.util.Scanner;

public class libraryUser {//end of class
    public static boolean isReturningBook;
    protected static boolean alwaysTrue = true;
    static Scanner userInput = new Scanner(System.in);

    public static void libraryMenu(Book[] books) {//start of Method
        while (alwaysTrue) {//start of whileLoop
            output.printVar(books);
            int inputChoice;
            int indexChoice;
            System.out.print("Please select a index: 1 - 3: ");
            inputChoice = userInput.nextInt();

            //IF user wants to Loan out a book
            if (inputChoice == 1) {//start of IF
                //codeeeee
                System.out.print("Which book would you like to loan out? (use the index)");
                indexChoice = userInput.nextInt() - 1;
                System.out.println(books[indexChoice]);
                isReturningBook = false;
            }//end of IF
            //IF user wants to return a book
            if (inputChoice == 2) {
                //codeeeeeerrrrs
                isReturningBook = true;
            }
            if (inputChoice == 3) {
                break;
            }
        }//end of whileLoop
    }//end of method
    //perhaps the user can make a transaction?
    //that saves to a method in class Storage?
}//end of class
