package Menu;

import Books.Book;


public class output {//start of class

    public static void printMenu() {//start of method printMenu
        System.out.printf("[1]\t%s%n", "Loan Books");
        System.out.printf("[2]\t%s%n", "Return Books");
        System.out.printf("[3]\t%s%n", "Exit");
    }//end of method printMenu

    public static void printVar(Book[] bookObjArray) {//start of method printVar
        for (int i = 0; i < bookObjArray.length; i++) {//start of for loop
            int count = i + 1;
            if (i < 9) {//if statement
                System.out.println("[" + count + "]  " + bookObjArray[i]);
            }//end of if
            else {//start of else
                System.out.println("[" + count + "] " + bookObjArray[i]);
            }//end of else
        }//end of for loop
        System.out.println();
    }//end of method printVar
}//end of class
